package com.example.iot.controller;

import com.example.iot.entity.Car;
import com.example.iot.relationship.CarIn;
import com.example.iot.relationship.CarOut;
import com.example.iot.mapper.ControlCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class ControlCenterController {

    @Autowired      //注入下面的mapper
    private ControlCenterMapper controlCenterMapper;

    @PostMapping("/controlCenterIn")        //进场控制
    public String save(@RequestBody CarIn carIn){
        // 判断进场的车辆是否是业主 不是业主还要先加入小区车辆表
        // 查询小区车辆表
        List<Car> listOfCar = controlCenterMapper.findCar(carIn.carInCarID);
        if (listOfCar.isEmpty()){
            // 如果查找不到 说明是第一次进入小区的访客 需要将其添加到小区车辆数据库中

            // 插入前 先进行格式判断
            if(carIn.carInCarID.length()!=7){
                return "新访客车牌格式错误";
            }
            else if(!Objects.equals(carIn.carInCarType, "1") && !Objects.equals(carIn.carInCarType, "2")){
                return "车辆类型错误";
            }

            // 格式正确 正式插入
            int i = controlCenterMapper.insertCar(carIn.carInCarID, carIn.carInCarType);
            if(i==0){
                return "新访客车辆插入错误";
            }
        }

        // 插入进场记录
        // 判断外键约束
        List<Integer> listBarrierEquipment = controlCenterMapper.foreignKey();
        if (!listBarrierEquipment.contains(carIn.carInBarrierEquipmentID)){
            return "外键不存在";
        }

        // 判断插入元素的格式是否正确
        if(carIn.carInDescription.length()>100){
            return "进场描述过长";
        }

        // 正式插入
        int j = controlCenterMapper.insertCarIn(carIn);
        if(j>0){
            return "进场记录插入成功";
        }
        else{
            return "进场记录插入失败";
        }
    }

    @PostMapping("/controlCenterOut")        //出场控制
    public String save(@RequestBody CarOut carOut){
        // 实际出场的车辆一定是进过场的 小区车辆表中一定有过登记

        // 插入出场记录
        // 判断外键约束 不需要判断车辆
        List<Integer> listBarrierEquipment = controlCenterMapper.foreignKey();
        if (!listBarrierEquipment.contains(carOut.carOutBarrierEquipmentID)){
            return "外键不存在";
        }

        // 判断输入格式是否符合规范
        if(carOut.carOutCarID.length() != 7){
            return "车牌格式错误";
        }
        else if(carOut.carOutDescription.length()>100){
            return "出场描述过长";
        }

        // 正式插入
        int j = controlCenterMapper.insertCarOut(carOut);
        if(j>0){
            return "出场记录插入成功";
        }
        else{
            return "出场记录插入失败";
        }
    }
}
