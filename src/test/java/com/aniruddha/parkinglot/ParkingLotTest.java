package com.aniruddha.parkinglot;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aniruddha Sinha on 12-02-2016.
 */
public class ParkingLotTest {
    @Test
    public void itShouldCheckWhetherTheLotHasFreeSpace(){
        //given
        ParkingLot lot=new ParkingLot(5);
        //when
        assertFalse(lot.hasFreeSpace());
        //then
    }
    @Test(expected = NullLotCreatedException.class)
    public void itShouldTestWhetherInvalidParkingLotCreated(){
        //given
        ParkingLot lot=new ParkingLot(0);
        //when
        //then
    }

    @Test
    public void itShouldParkCarWhenTheLotHasFreeSpace(){
        //given
        int INITIAL_SPACE=4;
        ParkingLot lot=new ParkingLot(INITIAL_SPACE);
        Car car=new Car("XYZ123");
        //when
        lot.parkCar(car);
        //then
        int FINAL_SPACE=lot.getFreeSpaceStatus();
        assertTrue(INITIAL_SPACE<FINAL_SPACE);
    }
}
