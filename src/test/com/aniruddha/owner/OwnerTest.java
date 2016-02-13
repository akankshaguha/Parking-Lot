package com.aniruddha.owner;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by Aniruddha Sinha on 14-02-2016.
 */
public class OwnerTest {
    @Test
    public void theOwnerShouldSetTheFullSignBoardAsFalse() {
        //given
        ParkingLotOwner owner = new ParkingLotOwner();
        //when
        Assert.assertFalse(owner.isFullSignBoardSet());
        //then
    }

    @Test
    public void theOwnerShouldBeAssuredThatTheOwnerisNotifiedOfTheSpaceFull() {
        //given
        ParkingLotOwner owner = new ParkingLotOwner();
        //when
        owner.notifyFull();
        //then
        Assert.assertTrue(owner.isFullSignBoardSet());
    }

    @Test
    public void theOwnerShouldBeNotifiedOfTheAvailableSpaceAndTheFullSignBoardIsRemovedSubsequently() {
        //given
        ParkingLotOwner owner = new ParkingLotOwner();
        //when
        Assert.assertFalse(owner.isFullSignBoardRemoved());
        //then
    }
}
