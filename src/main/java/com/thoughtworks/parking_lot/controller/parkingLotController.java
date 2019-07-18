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
    public List<ParkingLot> getAllParkingLot(@RequestParam int page,@RequestParam(defaultValue = "15") int pageSize){
        return parkingLotService.getAllParkingLot(page,pageSize);
    }

    @DeleteMapping("/{name}")
    public boolean deleteParkingLot(@PathVariable String name){
       return parkingLotService.deleteParkingLot(name);
    }

    @GetMapping("/{name}")
    public ParkingLot getParkingLot(@PathVariable String name){
        return parkingLotService.findByName(name);
    }

    @PutMapping("/{name}")
    public ParkingLot updateParkingLot(@PathVariable("name") String name,@RequestParam int capacity){
       return parkingLotService.updateParkingLot(name,capacity);
    }

}
