package com.parkinglot.app.model;

import com.parkinglot.app.constants.ParkingSpotType;
import com.parkinglot.app.constants.VehicleType;
import org.springframework.stereotype.Component;


public class Vehicle {

    private String registrationNumber;
    private VehicleType vehicleType;
    private ParkingSpotType parkingSpotType;


    public Vehicle() {
    }

    public Vehicle(VehicleType vehicleType, ParkingSpotType parkingSpotType){
        this.vehicleType = vehicleType;
        this.parkingSpotType = parkingSpotType;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType){
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public Vehicle(String registrationNumber, VehicleType vehicleType, ParkingSpotType parkingSpotType){
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
        this.parkingSpotType = parkingSpotType;
    }

    public ParkingSpotType getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(ParkingSpotType parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public int hashCode() {
        return this.registrationNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Vehicle vehicle = (Vehicle) obj;
        return this.registrationNumber.hashCode() == vehicle.registrationNumber.hashCode();
    }
}
