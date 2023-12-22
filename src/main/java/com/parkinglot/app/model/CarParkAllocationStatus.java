package com.parkinglot.app.model;

public class CarParkAllocationStatus {
    private String status;
    private ParkingSpot parkingSpot;

    public CarParkAllocationStatus(String status) {
        this.status = status;
    }

    public CarParkAllocationStatus(String status, ParkingSpot parkingSpot) {
        this.status = status;
        this.parkingSpot = parkingSpot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
