package com.parkinglot.app.factory;

import com.parkinglot.app.exception.UnknownParkingSpotException;
import com.parkinglot.app.model.ParkingSpot;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ParkingSpotFactory {

    private final Map<String, ParkingSpot> parkingSpotMap;

    public ParkingSpotFactory(Map<String, ParkingSpot> parkingSpotMap){
        this.parkingSpotMap = parkingSpotMap;
    }

    public ParkingSpot getParkingSpotInstance(String parkingSpot) throws UnknownParkingSpotException {
        return Optional.ofNullable(parkingSpotMap.get(parkingSpot))
                .orElseThrow(() -> new UnknownParkingSpotException("Unknown Parking Spot"));
    }

}
