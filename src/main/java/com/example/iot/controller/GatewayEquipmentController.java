package com.example.iot.controller;

import com.example.iot.entity.GatewayEquipment;
import com.example.iot.mapper.GatewayEquipmentMapper;
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
    public Integer addGatewayEquipment(@RequestBody GatewayEquipment gatewayEquipment) {
        gatewayEquipmentMapper.addGatewayEquipment(gatewayEquipment);
        return ResultCode.SUCCESS;
    }

    @DeleteMapping
    public Integer delGatewayEquipment(@RequestBody GatewayEquipment gatewayEquipment) {
        gatewayEquipmentMapper.delGatewayEquipment(gatewayEquipment.getGatewayEquipmentID());
        return ResultCode.SUCCESS;
    }
}
