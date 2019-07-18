package com.thoughtworks.parking_lot.repository;

import com.thoughtworks.parking_lot.entity.ParkingLot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

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

    @Test
    public void should_return_size_when_call_delete_parking_lot_given_name(){
        parkingLotRepository.deleteByName("oocl");
        assertEquals(0,parkingLotRepository.findAll().size());
    }

    @Test
    public void should_return_true_size_when_call_find_lot_given_page_pageSize(){
        int page = 1;
        int pageSize = 3;
        for (int i = 0; i < 6; i++) {
            ParkingLot p = new ParkingLot("oocl"+i,5,"zh"+i);
            parkingLotRepository.save(p);
        }
        List<ParkingLot> parkingLotList = parkingLotRepository.findAll(PageRequest.of(page,pageSize)).getContent();
        assertEquals(3,parkingLotList.size());
    }

}