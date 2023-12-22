package com.parkinglot.app.factory;

import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.exception.UnknownParkingLotImplementationException;
import com.parkinglot.app.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class ParkingLotFactory {

    private Map<String, ParkingLot> parkingLotImplementationMap;

    @Autowired
    public ParkingLotFactory(Map<String, ParkingLot> parkingLotImplementationMap){
        this.parkingLotImplementationMap = parkingLotImplementationMap;
    }

    /**
     * Returns the desired implementation of parking lot
     * @param parkingLotImplmentation
     * @return
     * @throws UnknownParkingLotImplementationException
     */
    public ParkingLot getParkingLotImplementation(String parkingLotImplmentation) throws UnknownParkingLotImplementationException {
        return Optional.ofNullable(parkingLotImplementationMap.get(parkingLotImplmentation))
                .orElseThrow(() -> new UnknownParkingLotImplementationException(Constants.UNKNOWN_PARKING_LOT_IMPLEMENTATION));
    }

}
