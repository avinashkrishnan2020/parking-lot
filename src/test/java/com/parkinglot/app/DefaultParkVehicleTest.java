package com.parkinglot.app;


import com.parkinglot.app.constants.Constants;
import com.parkinglot.app.constants.ParkingSpotType;
import com.parkinglot.app.constants.VehicleType;
import com.parkinglot.app.exception.ParkingFullException;
import com.parkinglot.app.exception.UnknownParkingSpotException;
import com.parkinglot.app.exception.VehicleNotFoundException;
import com.parkinglot.app.exception.VehicleParkedException;
import com.parkinglot.app.factory.ParkingSpotFactory;
import com.parkinglot.app.model.*;
import com.parkinglot.app.service.DefaultParkVehicleService;
import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.CopyOnWriteArrayList;

@ExtendWith(MockitoExtension.class)
public class DefaultParkVehicleTest {

    @Mock
    private ParkingSpotFactory parkingSpotFactoryMock;

    private Vehicle vehicle;
    private ParkingLot parkingLot;


    @Test
    @Description("Succesfully park vehicle")
    public void parkVehicleSuccessFully() throws UnknownParkingSpotException, ParkingFullException, VehicleParkedException {

        DefaultParkVehicleService defaultParkVehicleService = new DefaultParkVehicleService(parkingSpotFactoryMock);

        Vehicle vehicle = new Car("KL92AB454", VehicleType.CAR, ParkingSpotType.CAR);
        ParkingLot parkingLot = new DefaultParkingLot();

        Mockito.when(parkingSpotFactoryMock.getParkingSpotInstance(vehicle.getParkingSpotType().getParkingSpotType()))
                .thenReturn(new CarParkingSpot());

        CarParkAllocationStatus result = defaultParkVehicleService.parkVehicle(vehicle, parkingLot);
        Assertions.assertEquals(result.getStatus(), Constants.SUCCESSFUL);

    }

    @Test
    @Description("Avoid duplicate vehicles")
    public void parkVehicleFailed() throws UnknownParkingSpotException, ParkingFullException, VehicleParkedException {
        DefaultParkVehicleService defaultParkVehicleService = new DefaultParkVehicleService(parkingSpotFactoryMock);
        Vehicle vehicle = new Car("KL92AB454", VehicleType.CAR, ParkingSpotType.CAR);

        ParkingLot parkingLot = new DefaultParkingLot();

        // Add vehicle object to list. This means vehicle was already parked before.
        ((CopyOnWriteArrayList<ParkingSpot>)parkingLot.getParkingLot()).add(new CarParkingSpot(vehicle, System.currentTimeMillis()));


        Assertions.assertThrows(VehicleParkedException.class, () -> defaultParkVehicleService.parkVehicle(vehicle, parkingLot));


    }

    @Test
    @Description("Throw ParkingFullException when trying to add vehicle to parking that is full.")
    public void parkingFull() throws UnknownParkingSpotException, ParkingFullException, VehicleParkedException {
        DefaultParkVehicleService defaultParkVehicleService = new DefaultParkVehicleService(parkingSpotFactoryMock);
        Vehicle vehicle1= new Car("KL92A55", VehicleType.CAR, ParkingSpotType.CAR);
        Vehicle vehicle2= new Car("KL92AB455", VehicleType.CAR, ParkingSpotType.CAR);

        ParkingLot parkingLot = new DefaultParkingLot();
        CopyOnWriteArrayList<ParkingSpot> parking = (CopyOnWriteArrayList<ParkingSpot>) parkingLot.getParkingLot();
        for(int i=0; i<Constants.MAX_PARK_CAPACITY; i++){
            parking.add(new CarParkingSpot(vehicle1, System.currentTimeMillis()));
        }
        Assertions.assertThrows(ParkingFullException.class, () -> defaultParkVehicleService.parkVehicle(vehicle2, parkingLot));
    }

    @Test
    @Description("Unpark vehicle successfully")
    public void unparkVehicleSuccessfully() throws UnknownParkingSpotException, ParkingFullException, VehicleParkedException, VehicleNotFoundException {

        DefaultParkVehicleService defaultParkVehicleService = new DefaultParkVehicleService(parkingSpotFactoryMock);

        Vehicle vehicle = new Car("KL92AB454", VehicleType.CAR, ParkingSpotType.CAR);

        ParkingLot parkingLot = new DefaultParkingLot();

        // Add vehicle object to list. This means vehicle was already parked before.
        ((CopyOnWriteArrayList<ParkingSpot>)parkingLot.getParkingLot()).add(new CarParkingSpot(vehicle, System.currentTimeMillis(), Double.valueOf(2)));

        CarParkDeallocationStatus result = defaultParkVehicleService.unParkVehicle(vehicle, parkingLot);

        Assertions.assertEquals(result.getStatus(), Constants.SUCCESSFUL);
    }

    @Test
    @Description("Throw VehicleNotFoundException")
    public void throwVehicleNotFoundExceptionWhenUnavailableInParkingList() throws UnknownParkingSpotException, ParkingFullException, VehicleParkedException, VehicleNotFoundException {

        DefaultParkVehicleService defaultParkVehicleService = new DefaultParkVehicleService(parkingSpotFactoryMock);

        Vehicle vehicle1 = new Car("KL92A54", VehicleType.CAR, ParkingSpotType.CAR);
        Vehicle vehicle2 = new Car("KL92AB454", VehicleType.CAR, ParkingSpotType.CAR);

        ParkingLot parkingLot = new DefaultParkingLot();

        // Add vehicle object to list. This means vehicle was already parked before.
        ((CopyOnWriteArrayList<ParkingSpot>)parkingLot.getParkingLot()).add(new CarParkingSpot(vehicle1, System.currentTimeMillis(), Double.valueOf(2)));

        Assertions.assertThrows(VehicleNotFoundException.class, () -> defaultParkVehicleService.unParkVehicle(vehicle2, parkingLot));
    }


}
