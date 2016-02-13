package com.aniruddha.parkinglot;

/**
 * Created by Aniruddha Sinha on 13-02-2016.
 */
public class Car {
    private String carNumber;
    public Car(String carNumber) {
        if (carNumber.isEmpty()) throw new InvalidCarNumberException();
        this.carNumber = carNumber;
    }

    protected class InvalidCarNumberException extends RuntimeException {
    }
}
