package com.parkinglot.app.constants;

public enum ParkVehicleServiceStrategyType {

    DEFAULT_PARK_VEHICLE_SERVICE_STRATEGY(Constants.DEFAULT_PARK_VEHICLE_SERVICE);

    private String parkVehicleServiceStrategyType;

    ParkVehicleServiceStrategyType(String parkVehicleServiceStrategyType) {
        this.parkVehicleServiceStrategyType = parkVehicleServiceStrategyType;
    }

    public String getParkVehicleServiceStrategyType() {
        return parkVehicleServiceStrategyType;
    }

    public void setParkVehicleServiceStrategyType(String parkVehicleServiceStrategyType) {
        this.parkVehicleServiceStrategyType = parkVehicleServiceStrategyType;
    }
}
