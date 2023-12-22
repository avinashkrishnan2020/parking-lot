package com.parkinglot.app.constants;

public enum ParkingLotType {
    DEFAULT_PARKING_LOT("defaultParkingLot");

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
