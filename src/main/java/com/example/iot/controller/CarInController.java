package com.example.iot.controller;

import com.example.iot.relationship.CarIn;
import com.example.iot.mapper.CarInMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class CarInController {
    @Autowired      //注入下面的mapper
    private CarInMapper carInMapper;

    @GetMapping("/carIn")         //查询进场信息
    public List query(String CarID){
        List<CarIn> list;
        if (Objects.equals(CarID, "")){
            list = carInMapper.findAll();       //无条件查询
        }
        else {
            list= carInMapper.findCarID(CarID);     //输入车牌号查询
        }
        System.out.println(list);
        return list;
    }

}
