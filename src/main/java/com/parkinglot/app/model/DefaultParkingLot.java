package com.parkinglot.app.model;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class DefaultParkingLot implements ParkingLot<CopyOnWriteArrayList<ParkingSpot>>{

    private CopyOnWriteArrayList<ParkingSpot> parkingSpots = new CopyOnWriteArrayList<>();


    @Override
    public CopyOnWriteArrayList<ParkingSpot> getParkingLot() {
        return parkingSpots;
    }
}
