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
        if (personMapper.findPersonByID(car.getcarOwnerID()).isEmpty()) {
            result.setCode(20001);
            result.setMessage("未在小区业主中找到该车辆的拥有者！");
        } else if (car.getcarID().length() != 7) {
            result.setCode(20001);
            result.setMessage("车牌号位数错误，应为7位！");
        } else if (car.getcarType().isEmpty() || (!Objects.equals(car.getcarType(), "1") && !Objects.equals(car.getcarType(), "2"))) {
            result.setCode(20001);
            result.setMessage("车辆类型错误！");
        } else if (car.getcarIsRegistered().isEmpty() || (!Objects.equals(car.getcarIsRegistered(), "1") && !Objects.equals(car.getcarIsRegistered(), "0"))) {
            result.setCode(20001);
            result.setMessage("车辆登记类型错误！");
        } else {
            result.setCode(20000);
            result.setMessage("添加成功！");
            carMapper.addCar(car);
        }
        return result;
    }

    @DeleteMapping
    public Integer delCar(@RequestBody Car car) {
        carMapper.delCar(car.getcarID());
        return ResultCode.SUCCESS;
    }
}
