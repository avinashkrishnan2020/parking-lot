package com.parkinglot.app.model;

public class ParkingSpot {

    private Vehicle vehicle;
    private long vehicleParkStartTime;
    private Double fee;

    public ParkingSpot() {
    }

    public ParkingSpot(Vehicle vehicle, long vehicleParkStartTime) {
        this.vehicle = vehicle;
        this.vehicleParkStartTime = vehicleParkStartTime;
    }

    public Vehicle getVehicle() {

        return vehicle;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public void setVehicle(Vehicle vehicle) {

        this.vehicle = vehicle;
    }

    public long getVehicleParkStartTime() {

        return vehicleParkStartTime;
    }

    public void setVehicleParkStartTime(long vehicleParkStartTime) {

        this.vehicleParkStartTime = vehicleParkStartTime;
    }
}
