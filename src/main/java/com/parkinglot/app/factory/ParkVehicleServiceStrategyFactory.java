package com.parkinglot.app.factory;


import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.exception.UnknownParkVehicleStrategyException;
import com.parkinglot.app.service.DefaultParkVehicleService;
import com.parkinglot.app.service.ParkVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ParkVehicleServiceStrategyFactory {

    private final Map<String, ParkVehicleService> parkVehicleServiceStrategyMap;

    @Autowired
    public ParkVehicleServiceStrategyFactory(Map<String, ParkVehicleService> parkVehicleServiceStrategyMap){
        this.parkVehicleServiceStrategyMap = parkVehicleServiceStrategyMap;
    }

    public ParkVehicleService getParkVehicleServiceStrategy(String parkVehicleServiceStrategy) throws UnknownParkVehicleStrategyException {

        return Optional.ofNullable(parkVehicleServiceStrategyMap.get(parkVehicleServiceStrategy))
                .orElseThrow(() -> new UnknownParkVehicleStrategyException(Constants.UNKNOWN_PARK_VEHICLE_SERVICE_STRATEGY));

    }
}
