package com.example.iot.controller;

import com.example.iot.relationship.CarOut;
import com.example.iot.mapper.CarOutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class CarOutController {
    @Autowired      //注入下面的mapper
    private CarOutMapper carOutMapper;

    @GetMapping("/carOut")         //查询进场信息
    public List query(String CarID){
        List<CarOut> list;
        if (Objects.equals(CarID, "")){
            list = carOutMapper.findAll();       //无条件查询
        }
        else {
            list= carOutMapper.findCarID(CarID);     //输入车牌号查询
        }
        System.out.println(list);
        return list;
    }
}
