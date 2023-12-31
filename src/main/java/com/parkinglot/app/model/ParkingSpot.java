package com.parkinglot.app.model;

public class ParkingSpot {

    private Vehicle vehicle;
    private long vehicleParkStartTime;
    private Double feePerHour;

    public ParkingSpot() {
    }

    public ParkingSpot(Vehicle vehicle, long vehicleParkStartTime) {
        this.vehicle = vehicle;
        this.vehicleParkStartTime = vehicleParkStartTime;
    }

    public ParkingSpot(Vehicle vehicle, long vehicleParkStartTime, Double feePerHour) {
        this.vehicle = vehicle;
        this.vehicleParkStartTime = vehicleParkStartTime;
        this.feePerHour = feePerHour;
    }

    public Vehicle getVehicle() {

        return vehicle;
    }

    public Double getFeePerHour() {
        return feePerHour;
    }

    public void setFeePerHour(Double feePerHour) {
        this.feePerHour = feePerHour;
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
