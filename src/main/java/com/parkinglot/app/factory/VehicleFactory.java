package com.parkinglot.app.factory;

import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.constants.VehicleType;
import com.parkinglot.app.exception.UnknownVehicleTypeException;
import com.parkinglot.app.model.ParkVehicleRequestBody;
import com.parkinglot.app.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class VehicleFactory {

    private final Map<String, Vehicle> vehicleImplementationMap;

    @Autowired
    public VehicleFactory(Map<String, Vehicle> vehicleImplementationMap){
        this.vehicleImplementationMap = vehicleImplementationMap;
    }
    public Vehicle getVehicleInstance(ParkVehicleRequestBody requestBody) throws UnknownVehicleTypeException {
        return Optional.ofNullable(this.vehicleImplementationMap.get(requestBody.getVehicleType()))
                .orElseThrow(() -> new UnknownVehicleTypeException(Constants.UNKNOWN_VEHICLE_TYPE));

    }
}
