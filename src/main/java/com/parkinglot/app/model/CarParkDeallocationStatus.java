package com.parkinglot.app.model;

public class CarParkDeallocationStatus {
    private String status;
    private Double parkingFee;

    public CarParkDeallocationStatus(String status, Double parkingFee) {
        this.status = status;
        this.parkingFee = parkingFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(Double parkingFee) {
        this.parkingFee = parkingFee;
    }
}
