package com.parkinglot.app.service;

import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.exception.ParkingFullException;
import com.parkinglot.app.exception.UnknownParkingSpotException;
import com.parkinglot.app.exception.VehicleNotFoundException;
import com.parkinglot.app.exception.VehicleParkedException;
import com.parkinglot.app.factory.ParkingSpotFactory;
import com.parkinglot.app.model.*;
import com.parkinglot.app.util.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class DefaultParkVehicleService implements ParkVehicleService{

    private final ParkingSpotFactory parkingSpotFactory;

    @Autowired
    public DefaultParkVehicleService(ParkingSpotFactory parkingSpotFactory){
        this.parkingSpotFactory = parkingSpotFactory;
    }

    @Override
    public CarParkAllocationStatus parkVehicle(Vehicle vehicle, ParkingLot parkingLot) throws ParkingFullException, VehicleParkedException, UnknownParkingSpotException {

        CopyOnWriteArrayList<ParkingSpot> parkingSpots = (CopyOnWriteArrayList<ParkingSpot>)parkingLot.getParkingLot();

        // throw exception is parking full, else park vehicle
        if(parkingSpots.size() == Constants.MAX_PARK_CAPACITY){
            throw new ParkingFullException(Constants.PARKING_LOT_FULL_ERROR_MESSAGE);
        }

        if(parkingSpots.stream().anyMatch(parkingSpot -> parkingSpot.getVehicle().equals(vehicle))){
            throw new VehicleParkedException(Constants.VEHICLE_PARKED_ERROR_MESSAGE);
        }

        ParkingSpot parkingSpot = addVehicleToParkingSpot(vehicle);
        parkingSpots.add(parkingSpot);

        return new CarParkAllocationStatus(Constants.SUCCESSFUL, parkingSpot);
    }


    @Override
    public CarParkDeallocationStatus unParkVehicle(Vehicle vehicle, ParkingLot parkingLot) throws VehicleNotFoundException {

        CopyOnWriteArrayList<ParkingSpot> parkingSpots = (CopyOnWriteArrayList<ParkingSpot>)parkingLot.getParkingLot();

        for(ParkingSpot parkingSpot: parkingSpots){
            if(parkingSpot.getVehicle().equals(vehicle)){
                String totalParkingFee = calculateParkingFee(parkingSpot);
                // Remove vehicle
                parkingSpots.remove(parkingSpot);
                return new CarParkDeallocationStatus(Constants.SUCCESSFUL, totalParkingFee);
            }
        }
        // If vehicle not found, throw exception
        throw new VehicleNotFoundException(Constants.VEHICLE_NOT_FOUND_ERROR_MESSAGE);
    }

    @Override
    public String calculateParkingFee(ParkingSpot parkingSpot) {
        long timeElapsedInMilliseconds = System.currentTimeMillis()-parkingSpot.getVehicleParkStartTime();
        double hours = Utility.convertToHours(timeElapsedInMilliseconds);
        double totalFee = parkingSpot.getFeePerHour()*hours;
        String feeFormatted = Constants.GBP_CURRENCY + String.format(Constants.FEE_FORMAT, totalFee);
        return feeFormatted;
    }

    private ParkingSpot addVehicleToParkingSpot(Vehicle vehicle) throws UnknownParkingSpotException {

        ParkingSpot parkingSpot = parkingSpotFactory
                .getParkingSpotInstance(vehicle.getParkingSpotType().getParkingSpotType());

        parkingSpot.setVehicle(vehicle);
        parkingSpot.setVehicleParkStartTime(System.currentTimeMillis());
        parkingSpot.setFeePerHour(vehicle.getParkingSpotType().getFeePerHour());

        return parkingSpot;
    }
}
