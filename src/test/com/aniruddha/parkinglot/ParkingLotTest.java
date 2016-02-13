package com.aniruddha.parkinglot;

import com.aniruddha.owner.ParkingLotOwner;
import com.aniruddha.parkinglotObserver.ParkingLotObserver;
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

    @Test
    public void itShouldUnparkACarAndFreeTheLot() {
        //given
        int INITIAL_FREE_SPACE = 4;
        ParkingLot lot = new ParkingLot(INITIAL_FREE_SPACE);
        lot.parkCar(new Car("XYZ244"));
        lot.parkCar(new Car("ABC124"));
        lot.parkCar(new Car("ABC123"));
        lot.parkCar(new Car("ABC125"));
        int AVAILABLE_FREE_SPACE = lot.getFreeSpace();
        //when
        Assert.assertTrue(INITIAL_FREE_SPACE > AVAILABLE_FREE_SPACE);
        lot.unparkCar(new Car("XYZ244"));
        lot.unparkCar(new Car("ABC124"));
        lot.unparkCar(new Car("ABC123"));
        int SPACE_FREED = lot.getFreeSpace();
        //then
        Assert.assertTrue(SPACE_FREED > AVAILABLE_FREE_SPACE);
    }

    @Test(expected = ParkingLot.AttemptToUnparkUnavailableCarException.class)
    public void itShouldNotUnparkACarWhichIsNoMoreParkedInTheLot() {
        //given
        ParkingLot lot = new ParkingLot(4);
        lot.parkCar(new Car("XYZ244"));
        lot.parkCar(new Car("ABC124"));
        lot.parkCar(new Car("ABC123"));
        lot.parkCar(new Car("ABC125"));
        //when
        lot.unparkCar(new Car("XYZ244"));
        lot.unparkCar(new Car("ZZZ324"));
        //then
    }

    public void itShouldTellTheOwnerWhenTheLotIsFull() {
        //given
        ParkingLot lot = new ParkingLot(4);
        lot.parkCar(new Car("XYZ244"));
        lot.parkCar(new Car("ABC124"));
        lot.parkCar(new Car("ABC123"));
        lot.parkCar(new Car("ABC128"));

        //when
        ParkingLotObserver owner = new ParkingLotOwner();
        lot.registerObserver(owner);
        //then
        Assert.assertTrue(owner.isFullSignBoardSet());
    }
}
