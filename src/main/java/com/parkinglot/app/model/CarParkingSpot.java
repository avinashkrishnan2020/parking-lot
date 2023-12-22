package com.parkinglot.app.model;

import org.springframework.stereotype.Component;

@Component
public class CarParkingSpot extends ParkingSpot {

    public CarParkingSpot() {
        super();
    }

    public CarParkingSpot(Vehicle vehicle, long vehicleParkStartTime) {
        super(vehicle, vehicleParkStartTime);
    }

    public CarParkingSpot(Vehicle vehicle, long vehicleParkStartTime, Double fee) {
        super(vehicle, vehicleParkStartTime, fee);

    }
}
