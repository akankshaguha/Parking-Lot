package com.aniruddha.parkinglot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aniruddha Sinha on 12-02-2016.
 */
public class ParkingLot {
    private int freeSpace;
    private List<Car> lot;

    public ParkingLot(int allocatedFreeSpace) {
        if(allocatedFreeSpace==0) throw new NullLotCreatedException();
        this.freeSpace=allocatedFreeSpace;
        lot=new ArrayList<Car>();
    }

    public boolean hasFreeSpace() {
        return this.freeSpace==0;
    }

    public void parkCar(Car car) {
        if(hasFreeSpace()){
            lot.add(car);
            decrementFreeSpaceByOne();
        }
    }

    private void decrementFreeSpaceByOne() {
        this.freeSpace--;
    }


    public int getFreeSpaceStatus() {
        return this.freeSpace;
    }
}
