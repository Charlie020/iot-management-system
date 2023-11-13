package com.example.iot.controller;

import com.example.iot.entity.Car;
import com.example.iot.mapper.CarMapper;
import com.example.iot.mapper.PersonMapper;
import com.example.iot.utils.Result;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/communityCar")
public class CarController {
    @Autowired
    private CarMapper carMapper;
    @Autowired
    PersonMapper personMapper;

    @GetMapping
    public List<Car> findCar(@RequestParam(value = "carID", required = false) String carID) {
        List<Car> carList;
        if (carID == null) carID = "";
        if (carID.equals("")) {
            carList = carMapper.findAll();
        } else {
            carList = carMapper.findCarByID(carID);
        }
        return carList;
    }

    @PostMapping
    public Result addCar(@RequestBody Car car) {
        Result result = new Result();
        if (car.getcarID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写车牌号！");
        } else if (car.getcarType().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写车辆类型！");
        } else if (car.getcarIsRegistered().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写车辆是否已登记！");
        } else if (car.getcarOwnerID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写车辆拥有者的身份证号！");
        } else if (personMapper.findPersonByID(car.getcarOwnerID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("未在小区业主中找到该车辆的拥有者！");
        } else if (car.getcarID().length() != 7) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("车牌号位数错误，应为7位！");
        } else if (car.getcarType().isEmpty() || (!Objects.equals(car.getcarType(), "1") && !Objects.equals(car.getcarType(), "2"))) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("车辆类型错误！");
        } else if (car.getcarIsRegistered().isEmpty() || (!Objects.equals(car.getcarIsRegistered(), "1") && !Objects.equals(car.getcarIsRegistered(), "0"))) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("车辆登记类型错误！");
        } else {
            carMapper.addCar(car);
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("添加成功！");
        }
        return result;
    }

    @DeleteMapping
    public Result delCar(@RequestBody Car car) {
        Result result = new Result();
        if (car.getcarID().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写车牌号!");
        } else if (carMapper.findCarByID(car.getcarID()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("未找到该车辆!");
        } else {
            carMapper.delCar(car.getcarID());
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("删除成功!");
        }
        return result;
    }
}
