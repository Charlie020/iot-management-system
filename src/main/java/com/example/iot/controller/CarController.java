package com.example.iot.controller;

import com.example.iot.entity.Car;
import com.example.iot.mapper.CarMapper;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/communityCar")
public class CarController {
    @Autowired
    private CarMapper carMapper;

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
    public Integer addCar(@RequestBody Car car) {
        carMapper.addCar(car);
        return ResultCode.SUCCESS;
    }

    @DeleteMapping
    public Integer delCar(@RequestBody Car car) {
        carMapper.delCar(car.getcarID());
        return ResultCode.SUCCESS;
    }
}
