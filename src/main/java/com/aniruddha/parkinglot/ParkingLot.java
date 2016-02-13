package com.aniruddha.parkinglot;

import com.aniruddha.parkinglotObserver.ParkingLotObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aniruddha Sinha on 13-02-2016.
 */
public class ParkingLot {
    private int freeSpace;
    private List<Car> list;
    private List<ParkingLotObserver> observer;
    public ParkingLot(int i) {
        if (i == 0) throw new NullLotCreatedException();
        else {
            this.freeSpace = i;
            list = new ArrayList<Car>();
            observer = new ArrayList<ParkingLotObserver>();
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
            notifyOwner();
        } else throw new FreeSpaceExhaustedException();
    }

    private void notifyOwner() {
        if (isLotFull()) {
            observer.stream().forEach(e -> e.notifyFull());
        }
        if (!isLotFull()) {
            observer.stream().forEach(e -> e.isFullSignBoardRemoved());
        }
    }

    public int getFreeSpace() {
        return this.freeSpace;
    }

    public void unparkCar(Car car) {
        if (list.contains(car)) {
            list.remove(car);
            freeSpace++;
            notifyOwner();
        } else throw new AttemptToUnparkUnavailableCarException();
    }

    public void registerObserver(ParkingLotObserver owner) {
        observer.add(owner);
    }

    public boolean isLotFull() {
        return this.freeSpace == 0;
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
