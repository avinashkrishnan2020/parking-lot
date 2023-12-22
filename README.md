# Parking Lot

- This project is a Spring Boot API to park and unpark a vehicle from a parking lot.
- It exposes two Http POST endpoints for this purpose:
  - /park -> for parking a vehicle
  - /unpark -> to remove a vehicle from parking


## Sample request body for /park and /unpark:
```
{
    "vehicleType" : "car",
    "registrationNumber" : "KAB123867"
}
```
- Here, "registrationNumber" is a unique identification for a vehicle, and "vehicleType" describes the kind of vehice being parked (Car, Truck, etc.)


## Sample response for parking a vehicle:
```
{
    "status": "Successful",
    "parkingSpot": {
        "vehicle": {
            "registrationNumber": "KAB123867",
            "vehicleType": "CAR",
            "parkingSpotType": "CAR"
        },
        "vehicleParkStartTime": 1703271748017,
        "feePerHour": 2.0
    }
}
```
## Sample resopnse for removing a vehicle from parking lot
```
{
    "status": "Successful",
    "parkingFee": "£0.0292"
}
```
## Sample response when trying to park in a parking lot that is full
```
{
    "errorMessage": "Parking Lot is full."
}
```

## Software Design
- The software implements Factory Design Pattern and Strategy Design Pattern for reusability and maintainability.
- The application has Parent classes Vehicle and ParkingSpot. From this, different types of vehicles such as Car, Bike can be extended from Vehicle and different parking spots such as CarParkingSpot can be extended from ParkingSpot. This allows tremendous flexibility such as assigning different hourly parking rates for each vehicle types, etc.

- ![image](https://github.com/avinashkrishnan2020/parking-lot/assets/62984268/88bc9c10-4b22-4915-a099-00d379d72963)

- ![image](https://github.com/avinashkrishnan2020/parking-lot/assets/62984268/dd29f243-1d77-4a0d-a20c-c361cb01a52c)

- Similarly, an interface called ParkingLot is created so that we can implement different types of parking lots during the lifetime of the application. Here, a CopyOnWriteArrayList is used to add vehicles parked. This implementation has been developed as DefaultParkingLot class in the application.

-![image](https://github.com/avinashkrishnan2020/parking-lot/assets/62984268/b319e548-f9b6-4d37-a707-99f671c4d293)

- This will allow us to create different implementations of ParkingLot in the future.

### Factory Design
-The following are the Factory classes in the application. They enable us to create instances of the desired type on request.The instances are then passed on as arguments to Service class that parks a vehicle to its appropriate parking spot. The factory method allows us in reusing the same service methods to park and unpark a vehicle. This preserves the Liskov substituion principle in SOLID design.

![image](https://github.com/avinashkrishnan2020/parking-lot/assets/62984268/faed55dc-79c5-4ab6-8b7f-00cda2581764)


### Strategy Design Pattern
- This pattern lets us plug and play the desired park algorithm for the application. Currently, the application has a DefaultParkVehicleService(implements ParkVehicleService interface) which simple iterates through a CopyOnWriteArrayList<> and adds the vehicle into the list if not present already.
- In the future, we may utilize a more optimal algorithm to find parking spots that are near to entrance or elevator. In such cases, we can create a new implementation of ParkVehicleService interface and plug into the application.










