package com.aniruddha.owner;

import com.aniruddha.parkinglot.ParkingLot;
import com.aniruddha.parkinglotObserver.ParkingLotObserver;

/**
 * Created by Aniruddha Sinha on 14-02-2016.
 */
public class ParkingLotOwner implements ParkingLotObserver {
    boolean fullSignBoardSet;

    public ParkingLotOwner() {
        this.fullSignBoardSet = false;
    }

    @Override
    public void notifyFull() {
        this.fullSignBoardSet = true;

    }

    @Override
    public boolean isFullSignBoardSet() {

        return this.fullSignBoardSet;
    }

    @Override
    public boolean isFullSignBoardRemoved() {
        return this.fullSignBoardSet = false;
    }

}
