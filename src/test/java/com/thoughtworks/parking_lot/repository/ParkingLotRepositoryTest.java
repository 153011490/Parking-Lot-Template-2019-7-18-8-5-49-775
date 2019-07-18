package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ParkingLotRepositoryTest {

    @Autowired
    private ParkingLotRepository parkingLotRepository;
    private ParkingLot parkingLot;

    @Before
    public void setUp(){
        parkingLot = new ParkingLot("oocl",10,"zhuhai");
    }

    @Test
    public void should_return_size_when_call_add_parking_lot_given_parkinglot(){
        parkingLotRepository.save(parkingLot);
        assertEquals(1,parkingLotRepository.findAll().size());
    }

}