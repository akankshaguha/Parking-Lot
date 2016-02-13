package com.aniruddha.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aniruddha Sinha on 13-02-2016.
 */
public class ParkingLot {
    private int freeSpace;
    private List<Car> list;

    public ParkingLot(int i) {
        if (i == 0) throw new NullLotCreatedException();
        else {
            this.freeSpace = i;
            list = new ArrayList<Car>();
        }
    }

    public boolean isFreeSpaceAvailable() {
        return this.freeSpace != 0;
    }

    public void parkCar(Car car) {
        if (this.isFreeSpaceAvailable()) {
            if (list.contains(car)) throw new DuplicateCarParkedException();
            list.add(car);
            freeSpace--;
        } else throw new FreeSpaceExhaustedException();
    }

    public int getFreeSpace() {
        return this.freeSpace;
    }

    public void unparkCar(Car car) {
        if (list.contains(car)) {
            list.remove(car);
            freeSpace++;
        } else throw new AttemptToUnparkUnavailableCarException();
    }

    protected class NullLotCreatedException extends RuntimeException {
    }

    protected class FreeSpaceExhaustedException extends RuntimeException {
    }

    protected class DuplicateCarParkedException extends RuntimeException {
    }

    protected class AttemptToUnparkUnavailableCarException extends RuntimeException {
    }
}
