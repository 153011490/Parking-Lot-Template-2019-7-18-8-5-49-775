package com.thoughtworks.parking_lot.service;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<ParkingLot> getAllParkingLot(int page,int pageSize) {
        Pageable pageable= PageRequest.of(page-1,pageSize);
       return this.parkingLotRepository.findAll(pageable).getContent();
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

    @Override
    public ParkingLot findByName(String name) {
        return this.parkingLotRepository.findByName(name);
    }

    @Override
    public ParkingLot updateParkingLot(String name, int capacity) {
        ParkingLot parkingLot=this.parkingLotRepository.findByName(name);
        if(parkingLot!=null)return this.parkingLotRepository.save(parkingLot);
        return null;
    }
}
