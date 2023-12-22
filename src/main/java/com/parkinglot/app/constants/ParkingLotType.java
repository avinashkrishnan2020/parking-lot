package com.parkinglot.app.constants;

public enum ParkingLotType {
    DEFAULT_PARKING_LOT(Constants.DEFAULT_PARKING_LOT);

    private String parkingLotType;

    ParkingLotType(String parkingLotType) {
        this.parkingLotType = parkingLotType;
    }

    public String getParkingLotType() {
        return parkingLotType;
    }

    public void setParkingLotType(String parkingLotType) {
        this.parkingLotType = parkingLotType;
    }
}
