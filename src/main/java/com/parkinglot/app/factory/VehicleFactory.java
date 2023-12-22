package com.parkinglot.app.factory;

import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.constants.ParkingSpotType;
import com.parkinglot.app.constants.VehicleType;
import com.parkinglot.app.exception.UnknownVehicleTypeException;
import com.parkinglot.app.model.Car;
import com.parkinglot.app.model.Vehicle;
import com.parkinglot.app.model.VehicleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class VehicleFactory {


    public Vehicle getVehicleInstance(VehicleDetails requestBody) throws UnknownVehicleTypeException {

        if(Constants.CAR.equals(requestBody.getVehicleType())){
            return new Car(requestBody.getRegistrationNumber(),VehicleType.CAR, ParkingSpotType.CAR);
        }
        else{
            throw new UnknownVehicleTypeException(Constants.UNKNOWN_VEHICLE_TYPE);
        }

    }
}
