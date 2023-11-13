package com.example.iot.controller;

import com.example.iot.entity.GatewayEquipment;
import com.example.iot.mapper.GatewayEquipmentMapper;
import com.example.iot.utils.Result;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/gatewayEquipment")
public class GatewayEquipmentController {
    @Autowired
    private GatewayEquipmentMapper gatewayEquipmentMapper;

    @GetMapping
    public List<GatewayEquipment> findGatewayEquipment(@RequestParam(value = "gatewayEquipmentID", required = false) String gatewayEquipmentIDtmp,
                                                       @RequestParam(value = "gatewayEquipmentIP", required = false) String gatewayEquipmentIP,
                                                       @RequestParam(value = "gatewayEquipmentMacAddress", required = false) String gatewayEquipmentMacAddress) {
        List<GatewayEquipment> gatewayEquipmentList;
        if (gatewayEquipmentIDtmp == null) gatewayEquipmentIDtmp = "";
        if (gatewayEquipmentIP == null) gatewayEquipmentIP = "";
        if (gatewayEquipmentMacAddress == null) gatewayEquipmentMacAddress = "";

        int gatewayEquipmentID;
        if (Objects.equals(gatewayEquipmentIDtmp, "")) {
            gatewayEquipmentID = 0;
        } else {
            gatewayEquipmentID = Integer.valueOf(gatewayEquipmentIDtmp);
        }
        if (gatewayEquipmentID == 0 && Objects.equals(gatewayEquipmentIP, "") && Objects.equals(gatewayEquipmentMacAddress, "")) {
            // 三个皆为空
            gatewayEquipmentList = gatewayEquipmentMapper.findAll();
        } else if (gatewayEquipmentID == 0 && Objects.equals(gatewayEquipmentIP, "")) {
            // ID和IP为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByMacAddress(gatewayEquipmentMacAddress);
        } else if (gatewayEquipmentID == 0 && Objects.equals(gatewayEquipmentMacAddress, "")) {
            // ID和MacAddress为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByIP(gatewayEquipmentIP);
        } else if (Objects.equals(gatewayEquipmentIP, "") && Objects.equals(gatewayEquipmentMacAddress, "")) {
            // IP和MacAddress为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByID(gatewayEquipmentID);
        } else if (gatewayEquipmentID == 0) {
            // ID为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByIPAndMac(gatewayEquipmentIP, gatewayEquipmentMacAddress);
        } else if (Objects.equals(gatewayEquipmentIP, "")) {
            // IP为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByIDAndMac(gatewayEquipmentID, gatewayEquipmentMacAddress);
        } else if (Objects.equals(gatewayEquipmentMacAddress, "")) {
            // MacAddress为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByIDAndIP(gatewayEquipmentID, gatewayEquipmentIP);
        } else {
            // 三者皆不为空
            gatewayEquipmentList = gatewayEquipmentMapper.findGEByIDIPMac(gatewayEquipmentID, gatewayEquipmentIP, gatewayEquipmentMacAddress);
        }
        return gatewayEquipmentList;
    }

    @PostMapping
    public Result addGatewayEquipment(@RequestBody GatewayEquipment gatewayEquipment) {
        Result result = new Result();
        if (gatewayEquipment.getGatewayEquipmentName().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写门禁名称!");
        } else if (gatewayEquipment.getGatewayEquipmentIP().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写门禁IP!");
        } else if (gatewayEquipment.getGatewayEquipmentIPVersion().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写门禁的IP版本!");
        } else if (gatewayEquipment.getGatewayEquipmentMacAddress().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写门禁的Mac地址!");
        } else if (gatewayEquipment.getGatewayEquipmentBrand().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写门禁厂商!");
        } else if (!gatewayEquipmentMapper.findGEByName(gatewayEquipment.getGatewayEquipmentName()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("门禁设备名称重复!");
        } else {
            gatewayEquipmentMapper.addGatewayEquipment(gatewayEquipment);
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("插入成功!");
        }
        return result;
    }

    @DeleteMapping
    public Result delGatewayEquipment(@RequestBody GatewayEquipment gatewayEquipment) {
        Result result = new Result();
        if (gatewayEquipment.getGatewayEquipmentName().isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("请填写门禁名称!");
        } else if (gatewayEquipmentMapper.findGEByName(gatewayEquipment.getGatewayEquipmentName()).isEmpty()) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("门禁设备不存在！");
        } else {
            gatewayEquipmentMapper.delGatewayEquipment(gatewayEquipment.getGatewayEquipmentID());
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("删除成功！");
        }
        return result;
    }
}
