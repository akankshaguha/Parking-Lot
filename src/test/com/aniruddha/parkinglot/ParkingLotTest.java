package com.aniruddha.parkinglot;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Aniruddha Sinha on 13-02-2016.
 */
public class ParkingLotTest {
    @Test(expected = ParkingLot.NullLotCreatedException.class)
    public void itShouldNotAllowAnInvalidParkingLotToBeCreated() {
        //given
        ParkingLot lot = new ParkingLot(0);
        //when
        //then
    }

    @Test
    public void itShouldQueryWhetherFreeSpaceIsAvailable() {
        //given
        ParkingLot lot = new ParkingLot(4);
        //when
        Assert.assertTrue(lot.isFreeSpaceAvailable());
        //then
    }

    @Test
    public void itShouldParkACarInTheAvailableFreeSpace() {
        //given
        int INITIAL_SPACE = 4;
        ParkingLot lot = new ParkingLot(INITIAL_SPACE);
        //when
        Car car = new Car("XYZ123");
        lot.parkCar(car);
        //then
        int FINAL_SPACE = lot.getFreeSpace();
        Assert.assertTrue(INITIAL_SPACE > FINAL_SPACE);
        Assert.assertEquals(3, lot.getFreeSpace());
    }

    @Test(expected = Car.InvalidCarNumberException.class)
    public void itShouldNotAllowToParkACarWithAnInvalidCarNumber() {
        //given
        Car car = new Car("");
        //when
        //then
    }

    @Test(expected = ParkingLot.DuplicateCarParkedException.class)
    public void itShouldNotAllowSameCarToBeParkedMoreThanOnce() {
        //given
        ParkingLot lot = new ParkingLot(5);
        //when
        lot.parkCar(new Car("ABC123"));
        lot.parkCar(new Car("XYZ123"));
        lot.parkCar(new Car("ABC123"));
        //then
    }

    @Test(expected = ParkingLot.FreeSpaceExhaustedException.class)
    public void itShouldNotParkCarAfterTheFreeSpaceGetsExhausted() {
        //given
        ParkingLot lot = new ParkingLot(4);
        //when
        lot.parkCar(new Car("ABC123"));
        lot.parkCar(new Car("XYZ123"));
        lot.parkCar(new Car("ABC124"));
        lot.parkCar(new Car("ABC125"));
        lot.parkCar(new Car("ABC123"));/*The duplicate car numbered car has been entered here yet the test passes
                                         which indicates that the car has not been parked*/
        //then
    }
}
