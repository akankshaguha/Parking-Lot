package com.aniruddha.parkinglotObserver;

/**
 * Created by Aniruddha Sinha on 14-02-2016.
 */
public interface ParkingLotObserver {
    public void notifyFull();

    public boolean isFullSignBoardSet();

    public boolean isFullSignBoardRemoved();
}
