package com.parkinglot.app.controller;

import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.constants.ParkVehicleServiceStrategyType;
import com.parkinglot.app.constants.ParkingLotType;
import com.parkinglot.app.exception.*;
import com.parkinglot.app.factory.ParkVehicleServiceStrategyFactory;
import com.parkinglot.app.factory.ParkingLotFactory;
import com.parkinglot.app.factory.VehicleFactory;
import com.parkinglot.app.model.ParkVehicleRequestBody;
import com.parkinglot.app.model.ParkingLot;
import com.parkinglot.app.model.Vehicle;
import com.parkinglot.app.service.ParkVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ParkingLotController {

    private final ParkingLotFactory parkingLotFactory;
    private final VehicleFactory vehicleFactory;
    private final ParkVehicleServiceStrategyFactory parkVehicleServiceStrategyFactory;

    @Autowired
    public ParkingLotController(ParkingLotFactory parkingLotFactory, VehicleFactory vehicleFactory,
                                ParkVehicleServiceStrategyFactory parkVehicleServiceStrategyFactory){
        this.parkingLotFactory = parkingLotFactory;
        this.vehicleFactory = vehicleFactory;
        this.parkVehicleServiceStrategyFactory = parkVehicleServiceStrategyFactory;
    }

    @PostMapping("/park")
    public ResponseEntity<?> parkVehicle(@RequestBody ParkVehicleRequestBody parkVehicleRequestBody) throws UnknownVehicleTypeException, UnknownParkVehicleStrategyException, UnknownParkingLotImplementationException, ParkingFullException, UnknownParkingSpotException, VehicleParkedException {

        Vehicle vehicle = vehicleFactory.getVehicleInstance(parkVehicleRequestBody);
        vehicle.setRegistrationNumber(parkVehicleRequestBody.getRegistrationNumber());

        ParkingLot parkingLot = parkingLotFactory.getParkingLotImplementation(ParkingLotType.DEFAULT_PARKING_LOT.getParkingLotType());

        ParkVehicleService parkVehicleService = parkVehicleServiceStrategyFactory
                .getParkVehicleServiceStrategy(ParkVehicleServiceStrategyType.DEFAULT_PARK_VEHICLE_SERVICE_STRATEGY.getParkVehicleServiceStrategyType());

        return new ResponseEntity<>(parkVehicleService.parkVehicle(vehicle, parkingLot), HttpStatus.OK);



    }

    @PostMapping("/unpark")
    public ResponseEntity<?> unParkVehicle(@RequestBody ParkVehicleRequestBody unparkVehicleRequestBody) throws UnknownVehicleTypeException, UnknownParkVehicleStrategyException, UnknownParkingLotImplementationException, VehicleNotFoundException {

        Vehicle vehicle = vehicleFactory.getVehicleInstance(unparkVehicleRequestBody);
        vehicle.setRegistrationNumber(unparkVehicleRequestBody.getRegistrationNumber());

        ParkVehicleService parkVehicleService = parkVehicleServiceStrategyFactory
                .getParkVehicleServiceStrategy(ParkVehicleServiceStrategyType.DEFAULT_PARK_VEHICLE_SERVICE_STRATEGY.getParkVehicleServiceStrategyType());

        ParkingLot parkingLot = parkingLotFactory.getParkingLotImplementation(ParkingLotType.DEFAULT_PARKING_LOT.getParkingLotType());

        return new ResponseEntity<>(parkVehicleService.unParkVehicle(vehicle, parkingLot), HttpStatus.OK);


    }
}
