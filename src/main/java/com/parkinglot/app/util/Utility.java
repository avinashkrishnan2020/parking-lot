package com.parkinglot.app.util;

public class Utility {

    public static double convertToHours(long milliseconds){
        return (double) milliseconds / (1000 * 60 * 60);
    }
}
