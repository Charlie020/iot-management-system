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
        if (parkingSpaceID == null) parkingSpaceID = "";
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
        if (parkingSpace.getparkingSpaceID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写停车位ID！");
        } else if (parkingSpace.getparkingSpaceParkingLotID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写所属停车场ID！");
        } else if (parkingSpace.getparkingSpaceCarID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写该停车位所停车辆的车牌号！");
        } else if (parkingLotMapper.findParkingLotByID(parkingSpace.getparkingSpaceParkingLotID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("所属停车场不存在！");
        } else if (!parkingSpaceMapper.findByparkingSpaceID(parkingSpace.getparkingSpaceID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("停车位已存在！");
        } else if (carMapper.findCarByID(parkingSpace.getparkingSpaceCarID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("小区中不存在该车辆！");
        } else {
            parkingSpaceMapper.addParkingSpace(parkingSpace);
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("插入成功！");
        }
        return result;
    }

    @DeleteMapping
    public Result delParkingSpace(@RequestBody ParkingSpace parkingSpace) {
        Result result = new Result();
        if (parkingSpaceMapper.findByparkingSpaceID(parkingSpace.getparkingSpaceID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("需要删除的停车位不存在！");
        } else {
            parkingSpaceMapper.delParkingSpace(parkingSpace.getparkingSpaceID());
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("删除成功！");
        }
        return result;
    }
}
