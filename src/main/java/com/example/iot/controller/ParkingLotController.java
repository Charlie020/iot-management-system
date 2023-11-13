package com.example.iot.controller;

import com.example.iot.entity.ParkingLot;
import com.example.iot.mapper.ParkingLotMapper;
import com.example.iot.utils.Result;
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
        if (parkingLotID == null) parkingLotID = "";
        if (Objects.equals(parkingLotID, "")) {
            parkingLotList = parkingLotMapper.findAll();
        } else {
            parkingLotList = parkingLotMapper.findParkingLotByID(parkingLotID);
        }
        return parkingLotList;
    }

    @PostMapping
    public Result addParkingLot(@RequestBody ParkingLot parkingLot) {
        Result result = new Result();
        if (parkingLot.getparkingLotID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写停车场ID!");
        } else if (!parkingLotMapper.findParkingLotByID(parkingLot.getparkingLotID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("停车场ID重复！");
        } else {
            parkingLotMapper.addParkingLot(parkingLot);
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("插入成功！");
        }
        return result;
    }

    @DeleteMapping
    public Result delParkingLot(@RequestBody ParkingLot parkingLot) {
        Result result = new Result();
        if (parkingLot.getparkingLotID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写停车场ID!");
        } else if (parkingLotMapper.findParkingLotByID(parkingLot.getparkingLotID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("需要删除的停车场不存在！");
        } else {
            parkingLotMapper.delParkingLot(parkingLot.getparkingLotID());
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("删除成功！");
        }
        return result;
    }
}
