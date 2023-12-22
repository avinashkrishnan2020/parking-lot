package com.parkinglot.app.factory;

import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.exception.UnknownParkingSpotException;
import com.parkinglot.app.model.CarParkingSpot;
import com.parkinglot.app.model.ParkingSpot;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ParkingSpotFactory {


    public ParkingSpot getParkingSpotInstance(String parkingSpot) throws UnknownParkingSpotException {
        if(Constants.CAR_PARKING_SPOT.equals(parkingSpot)){
            return new CarParkingSpot();
        }
        else{
            throw new UnknownParkingSpotException(Constants.UNKNOWN_PARKING_SPOT_IMPLEMENTATION);
        }
    }

}
