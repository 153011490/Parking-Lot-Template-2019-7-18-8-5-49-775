package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;

import java.util.List;

public interface ParkingLotService {
    boolean addParkingLot(ParkingLot parkingLot);

    List<ParkingLot> getAllParkingLot(int page,int pageSize);

    boolean deleteParkingLot(String name);

    ParkingLot findByName(String name);
}
