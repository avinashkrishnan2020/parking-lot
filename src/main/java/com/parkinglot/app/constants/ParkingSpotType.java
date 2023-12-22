package com.parkinglot.app.constants;

public enum ParkingSpotType {
    CAR("carParkingSpot", 2.0);

    private String parkingSpotType;
    private Double fee;

    ParkingSpotType(String carParkingSpot, Double fee) {
        this.parkingSpotType = carParkingSpot;
        this.fee = fee;
    }

    public String getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(String parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }
}
