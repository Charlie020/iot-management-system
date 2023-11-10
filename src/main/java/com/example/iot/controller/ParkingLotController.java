package com.example.iot.controller;

import com.example.iot.entity.ParkingLot;
import com.example.iot.mapper.ParkingLotMapper;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/parkingLot")
public class ParkingLotController {
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping
    public List<ParkingLot> findParkingLot(@RequestParam(value = "parkingLotID", required = false) String parkingLotID) {
        List<ParkingLot> parkingLotList;
        if (Objects.equals(parkingLotID, "")) {
            parkingLotList = parkingLotMapper.findAll();
        } else {
            parkingLotList = parkingLotMapper.findParkingLotByID(parkingLotID);
        }
        return parkingLotList;
    }

    @PostMapping
    public Integer addParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.addParkingLot(parkingLot);
        return ResultCode.SUCCESS;
    }

    @DeleteMapping
    public Integer delParkingLot(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.delParkingLot(parkingLot.getparkingLotID());
        return ResultCode.SUCCESS;
    }
}
