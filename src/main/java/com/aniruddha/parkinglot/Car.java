package com.aniruddha.parkinglot;

import java.util.Objects;

/**
 * Created by Aniruddha Sinha on 13-02-2016.
 */
public class Car {
    private String carNumber;

    public Car(String carNumber) {

        if (carNumber.isEmpty()) throw new InvalidCarNumberException();
        this.carNumber = carNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(carNumber, car.carNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carNumber);
    }

    protected class InvalidCarNumberException extends RuntimeException {
    }
}
