package com.example.iot.controller;

import com.example.iot.entity.BarrierProtocol;
import com.example.iot.mapper.BarrierProtocolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
public class BarrierProtocolController {
    @Autowired      //注入下面的mapper
    private BarrierProtocolMapper barrierProtocolMapper;

    @GetMapping("/barrierProtocol")         //查询道闸协议
    public List query(String barrierProtocolName){
        List<BarrierProtocol> list;
        if (Objects.equals(barrierProtocolName, "")){
            list = barrierProtocolMapper.find1();       //无条件查询
        }
        else {
            list= barrierProtocolMapper.find2(barrierProtocolName);     //输入厂商名称查询
        }
        System.out.println(list);
        return list;
    }

    @PostMapping("/barrierProtocol")        //插入道闸协议
    public String save(@RequestBody BarrierProtocol barrierProtocol){
        // 判断主键和协议连接是否存在
        List<BarrierProtocol> list = barrierProtocolMapper.find2(barrierProtocol.barrierProtocolName);
        if (!list.isEmpty()){
            return "协议名称重复";
        }
        list = barrierProtocolMapper.findLink(barrierProtocol.barrierProtocolProtocolLink);
        if (!list.isEmpty()){
            return "协议链接重复";
        }

        // 判断插入数据取值是否符合规范
        if(barrierProtocol.barrierProtocolName.length()>20){
            return "协议名称过长";
        }
        else if(barrierProtocol.barrierProtocolVersion.length()>10){
            return "协议版本过长";
        }
        else if(barrierProtocol.barrierProtocolDeveloper.length()>10){
            return "开发者过长";
        }
        else if(barrierProtocol.barrierProtocolDeveloperPhone.length()!=11){
            return "手机号格式错误";
        }
        else if(barrierProtocol.barrierProtocolProtocolLink.length()>100){
            return "协议连接过长";
        }
        else if(!Objects.equals(barrierProtocol.barrierProtocolState, "启用") & !Objects.equals(barrierProtocol.barrierProtocolState, "禁用")){
            return "状态错误";
        }

        // 手机字段不能有字母
        for (int i = 0 ; i<barrierProtocol.barrierProtocolDeveloperPhone.length();i++){
            char c= barrierProtocol.barrierProtocolDeveloperPhone.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                return "手机号格式错误";
            }
        }

        //格式正确 可以插入
        int j = barrierProtocolMapper.insert(barrierProtocol);  //返回值表示插入状态
        if (j>0){
            return "插入成功";
        }
        else {
            return "插入失败";
        }
    }

    @PutMapping("/barrierProtocol")
    public String update(@RequestBody BarrierProtocol barrierProtocol){
        int i=0;
        if (Objects.equals(barrierProtocol.barrierProtocolState, "禁用")){
            i = barrierProtocolMapper.startUse(barrierProtocol.barrierProtocolName);  // 启用该协议
        }
        else {
            i = barrierProtocolMapper.startUnUse(barrierProtocol.barrierProtocolName);  // 禁用该协议
        }
        if (i>0){
            return "更新成功";
        }
        else {
            return "更新失败";
        }
    }

    @DeleteMapping("/barrierProtocol")
    public String delete(@RequestBody BarrierProtocol barrierProtocol){
        int i = barrierProtocolMapper.delete(barrierProtocol.barrierProtocolName);  // 删除该协议
        if (i>0){
            return "删除成功";
        }
        else {
            return "删除失败";
        }
    }
}
