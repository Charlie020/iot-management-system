package com.example.iot.controller;

import com.example.iot.entity.BarrierEquipment;
import com.example.iot.mapper.BarrierEquipmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class BarrierEquipmentController {
    @Autowired      //注入下面的mapper
    private BarrierEquipmentMapper barrierEquipmentMapper;

    @GetMapping("/barrierEquipment")         //查询道闸协议
    public List query(@RequestParam(value = "barrierEquipmentID", required = false) String ID, String barrierEquipmentIP, String barrierEquipmentMacAddress){
        List<BarrierEquipment> list;

        int barrierEquipmentID = 0;
        if (ID != null & !Objects.equals(ID, "")){        // get方法在路径传输只能传入字符串
            // 判断是否符合int规范
            for (int i = 0 ; i<ID.length();i++){
                if ((ID.charAt(i) >= 'a' && ID.charAt(i) <= 'z') || (ID.charAt(i) >= 'A' && ID.charAt(i) <= 'Z')){
                    list=null;
                    return list;
                }
            }
            barrierEquipmentID = Integer.parseInt(ID);      //符合规范
        }

        if (barrierEquipmentID == 0 & (Objects.equals(barrierEquipmentIP, "")) & Objects.equals(barrierEquipmentMacAddress, "")){
            // 无条件查询
            list = barrierEquipmentMapper.findNoCondition();
        }
        else if (barrierEquipmentID != 0 & Objects.equals(barrierEquipmentIP, "") & Objects.equals(barrierEquipmentMacAddress, "")){
            // 根据ID
            list = barrierEquipmentMapper.findId(barrierEquipmentID);
        }
        else if (barrierEquipmentID == 0 & !Objects.equals(barrierEquipmentIP, "") & Objects.equals(barrierEquipmentMacAddress, "")){
            // 根据Ip
            list = barrierEquipmentMapper.findIP(barrierEquipmentIP);
        }
        else if (barrierEquipmentID == 0 & Objects.equals(barrierEquipmentIP, "") & !Objects.equals(barrierEquipmentMacAddress, "")){
            // 根据mac
            list = barrierEquipmentMapper.findMac(barrierEquipmentMacAddress);
        }
        else if (barrierEquipmentID != 0 & !Objects.equals(barrierEquipmentIP, "") & Objects.equals(barrierEquipmentMacAddress, "")){
            // 根据ID and ip
            list = barrierEquipmentMapper.findIdIP(barrierEquipmentID, barrierEquipmentIP);
        }
        else if (barrierEquipmentID != 0 & Objects.equals(barrierEquipmentIP, "") & !Objects.equals(barrierEquipmentMacAddress, "")){
            // 根据ID and mac
            list = barrierEquipmentMapper.findIdMac(barrierEquipmentID, barrierEquipmentMacAddress);
        }
        else if (barrierEquipmentID == 0 & !Objects.equals(barrierEquipmentIP, "") & !Objects.equals(barrierEquipmentMacAddress, "")){
            // 根据Ip and mac
            list = barrierEquipmentMapper.findIPMac(barrierEquipmentIP, barrierEquipmentMacAddress);
        }
        else {
            // 根据ID ip mac
            list = barrierEquipmentMapper.findIdIPMac(barrierEquipmentID, barrierEquipmentIP, barrierEquipmentMacAddress);
        }
        System.out.println(list);
        return list;
    }

    @PostMapping("/barrierEquipment")        //插入道闸协议
    public String save(@RequestBody BarrierEquipment barrierEquipment){
        // 判断设备名称、IP是否存在
        List<BarrierEquipment> list = barrierEquipmentMapper.findName(barrierEquipment.barrierEquipmentName);
        if (!list.isEmpty()){
            return "设备名称重复";
        }
        list = barrierEquipmentMapper.findIP(barrierEquipment.barrierEquipmentIP);
        if (!list.isEmpty()){
            return "设备IP重复";
        }

        // 判断是否符合外键约束
        List<String> listProtocol = barrierEquipmentMapper.foreignKey();
        if (!listProtocol.contains(barrierEquipment.barrierEquipmentProtocol)){
            return "外键不存在";
        }

        // 外键道闸协议是否启用判断
        String state = barrierEquipmentMapper.idUsed(barrierEquipment.barrierEquipmentProtocol);
        if(!Objects.equals(state, "启用")){
            return "协议未启用";
        }

        // 判断插入数据取值是否符合规范
        if(barrierEquipment.barrierEquipmentName.length()>10){
            return "设备名称过长";
        }
        else if(!Objects.equals(barrierEquipment.barrierEquipmentDirection, "进") & !Objects.equals(barrierEquipment.barrierEquipmentDirection, "出")){
            return "道闸方向错误";
        }
        else if(barrierEquipment.barrierEquipmentIP.length()>30){
            return "IP过长";
        }
        else if(!Objects.equals(barrierEquipment.barrierEquipmentIPVersion, "4") & !Objects.equals(barrierEquipment.barrierEquipmentIPVersion, "6")){
            return "IP版本错误";
        }
        else if(barrierEquipment.barrierEquipmentMacAddress.length()>30){
            return "MAC过长";
        }

        // 格式正确
        int i = barrierEquipmentMapper.insert(barrierEquipment);  //返回值表示插入状态
        if (i>0){
            return "插入成功";
        }
        else {
            return "插入失败";
        }
    }

    @DeleteMapping("/barrierEquipment")
    public String delete(@RequestBody BarrierEquipment barrierEquipment){
        int i = barrierEquipmentMapper.delete(barrierEquipment.barrierEquipmentID);  // 删除该协议
        if (i>0){
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }
}
