package com.thoughtworks.parking_lot.controller;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import com.thoughtworks.parking_lot.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parkinglots")
public class parkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping
    public boolean addParkingLot(@RequestBody ParkingLot parkingLot){
        return parkingLotService.addParkingLot(parkingLot);
    }

    @GetMapping
    public List<ParkingLot> getAllParkingLot(){
        return parkingLotService.getAllParkingLot();
    }

}
