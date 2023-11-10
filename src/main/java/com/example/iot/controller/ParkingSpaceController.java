package com.example.iot.controller;

import com.example.iot.entity.ParkingSpace;
import com.example.iot.mapper.ParkingSpaceMapper;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/parkingSpace")
public class ParkingSpaceController {
    @Autowired
    private ParkingSpaceMapper parkingSpaceMapper;

    @GetMapping
    public List<ParkingSpace> findParkingSpace(@RequestParam(value = "parkingSpaceID", required = false) String parkingSpaceID) {
        List<ParkingSpace> parkingSpaceList;
        if (Objects.equals(parkingSpaceID, "")) {
            parkingSpaceList = parkingSpaceMapper.findAll();
        } else {
            parkingSpaceList = parkingSpaceMapper.findByparkingSpaceID(parkingSpaceID);
        }
        return parkingSpaceList;
    }

    @PostMapping
    public Integer addParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        parkingSpaceMapper.addParkingSpace(parkingSpace);
        return ResultCode.SUCCESS;
    }

    @DeleteMapping
    public Integer delParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        parkingSpaceMapper.delParkingSpace(parkingSpace.getparkingSpaceID());
        return ResultCode.SUCCESS;
    }
}
