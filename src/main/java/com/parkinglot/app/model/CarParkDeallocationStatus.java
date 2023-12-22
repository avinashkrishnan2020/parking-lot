package com.parkinglot.app.model;

public class CarParkDeallocationStatus {
    private String status;
    private String parkingFee;

    public CarParkDeallocationStatus(String status, String parkingFee) {
        this.status = status;
        this.parkingFee = parkingFee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getParkingFee() {
        return parkingFee;
    }

    public void setParkingFee(String parkingFee) {
        this.parkingFee = parkingFee;
    }
}
