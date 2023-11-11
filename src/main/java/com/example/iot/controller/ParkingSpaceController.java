package com.example.iot.controller;

import com.example.iot.entity.ParkingSpace;
import com.example.iot.mapper.CarMapper;
import com.example.iot.mapper.ParkingLotMapper;
import com.example.iot.mapper.ParkingSpaceMapper;
import com.example.iot.utils.Result;
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
    @Autowired
    private ParkingLotMapper parkingLotMapper;
    @Autowired
    private CarMapper carMapper;

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
    public Result addParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        Result result = new Result();
        if (parkingLotMapper.findParkingLotByID(parkingSpace.getparkingSpaceParkingLotID()).isEmpty()) {
            result.setMessage("所属停车场不存在！");
            result.setCode(ResultCode.ERROR);
        } else if (!parkingSpaceMapper.findByparkingSpaceID(parkingSpace.getparkingSpaceID()).isEmpty()) {
            result.setMessage("停车位已存在！");
            result.setCode(ResultCode.ERROR);
        } else if (carMapper.findCarByID(parkingSpace.getparkingSpaceCarID()).isEmpty()) {
            result.setMessage("小区中不存在该车辆！");
            result.setCode(ResultCode.ERROR);
        } else {
            result.setMessage("插入成功！");
            result.setCode(ResultCode.SUCCESS);
            parkingSpaceMapper.addParkingSpace(parkingSpace);
        }
        return result;
    }

    @DeleteMapping
    public Integer delParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        parkingSpaceMapper.delParkingSpace(parkingSpace.getparkingSpaceID());
        return ResultCode.SUCCESS;
    }
}
