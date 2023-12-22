package com.parkinglot.app.controlleradvice;

import com.parkinglot.app.exception.*;
import com.parkinglot.app.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParkingFullException.class)
    public ResponseEntity<?> handleParkingFullException(ParkingFullException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(UnknownParkingLotImplementationException.class)
    public ResponseEntity<?> handleUnknownParkingLotImplementationException(UnknownParkingLotImplementationException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnknownParkingSpotException.class)
    public ResponseEntity<?> handleUnknownParkingSpotException(UnknownParkingSpotException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnknownParkVehicleStrategyException.class)
    public ResponseEntity<?> handleUnknownParkVehicleStrategyException(UnknownParkVehicleStrategyException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnknownVehicleTypeException.class)
    public ResponseEntity<?> handleUnknownVehicleTypeException(UnknownVehicleTypeException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity<?> handleVehicleNotFoundException(VehicleNotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(VehicleParkedException.class)
    public ResponseEntity<?> handleVehicleParkedException(VehicleParkedException ex) {
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()), HttpStatus.FORBIDDEN);
    }




}
