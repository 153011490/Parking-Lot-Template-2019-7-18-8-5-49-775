package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingLotServiceImpl implements ParkingLotService{

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Override
    public boolean addParkingLot(ParkingLot parkingLot) {
        try{
            parkingLotRepository.save(parkingLot);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<ParkingLot> getAllParkingLot() {
       return this.parkingLotRepository.findAll();
    }

    @Override
    public boolean deleteParkingLot(String name) {
        try{
            this.parkingLotRepository.deleteByName(name);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
