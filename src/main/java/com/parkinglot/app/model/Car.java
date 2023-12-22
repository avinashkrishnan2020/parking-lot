package com.parkinglot.app.model;

import com.parkinglot.app.constants.ParkingSpotType;
import com.parkinglot.app.constants.VehicleType;
import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle{


    public Car() {
        super(VehicleType.CAR, ParkingSpotType.CAR);
    }

    public Car(String registrationNumber, VehicleType vehicleType) {

        super(registrationNumber, vehicleType);
    }

    public Car(String registrationNumber, VehicleType vehicleType, ParkingSpotType parkingSpotType){
        super(registrationNumber, vehicleType, parkingSpotType);
    }



}
