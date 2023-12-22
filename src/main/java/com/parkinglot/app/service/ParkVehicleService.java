package com.parkinglot.app.service;

import com.parkinglot.app.exception.ParkingFullException;
import com.parkinglot.app.exception.UnknownParkingSpotException;
import com.parkinglot.app.exception.VehicleNotFoundException;
import com.parkinglot.app.exception.VehicleParkedException;
import com.parkinglot.app.model.*;

import java.util.List;

public interface ParkVehicleService {

    public CarParkAllocationStatus parkVehicle(Vehicle vehicle, ParkingLot parkingLot) throws ParkingFullException, UnknownParkingSpotException, VehicleParkedException;
    public CarParkDeallocationStatus unParkVehicle(Vehicle vehicle, ParkingLot parkingLot) throws VehicleNotFoundException;
    public Double calculateParkingFee(ParkingSpot parkingSpot);
}
