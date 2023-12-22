package com.parkinglot.app.constants;

public enum ParkingSpotType {
    CAR(Constants.CAR_PARKING_SPOT, Constants.CAR_FEE_PER_HOUR);

    private String parkingSpotType;
    private Double feePerHour;

    ParkingSpotType(String carParkingSpot, Double feePerHour) {
        this.parkingSpotType = carParkingSpot;
        this.feePerHour = feePerHour;
    }

    public String getParkingSpotType() {
        return parkingSpotType;
    }

    public void setParkingSpotType(String parkingSpotType) {
        this.parkingSpotType = parkingSpotType;
    }

    public Double getFeePerHour() {
        return feePerHour;
    }

    public void setFeePerHour(Double feePerHour) {
        this.feePerHour = feePerHour;
    }
}
