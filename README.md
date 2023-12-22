# Parking Lot

- This project is a Spring Boot API to park and unpark a vehicle from a parking lot.
- It exposes two Http POST endpoints for this purpose:
  - /park -> for parking a vehicle
  - /unpark -> to remove a vehicle from parking


## Sample request body for /park and /unpark:
- {
    "vehicleType" : "car",
    "registrationNumber" : "KAB123867"
}
- Here, "registrationNumber" is a unique identification for a vehicle, and "vehicleType" describes the kind of vehice being parked (Car, Truck, etc.)


## Sample response for parking a vehicle:
- {
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

## Sample resopnse for removing a vehicle from parking lot
- {
    "status": "Successful",
    "parkingFee": "£0.0292"
}

## Sample response when trying to park in a parking lot that is full
- {
    "errorMessage": "Parking Lot is full."
}

