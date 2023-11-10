package com.example.iot.controller;

import com.example.iot.mapper.GatewayBindMapper;
import com.example.iot.relationship.GatewayBind;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/gatewayBind")
public class GatewayBindController {
    @Autowired
    GatewayBindMapper gatewayBindMapper;

    @GetMapping
    public List<GatewayBind> findGatewayBind(@RequestParam(value = "gatewayEquipmentName", required = false) String gatewayEquipmentName,
                                                       @RequestParam(value = "personName", required = false) String personName,
                                                       @RequestParam(value = "gatewayEquipmentID", required = false) String gatewayEquipmentIDtmp) {
        List<GatewayBind> gatewayBindList;
        int gatewayEquipmentID;
        if (Objects.equals(gatewayEquipmentIDtmp, "")) {
            gatewayEquipmentID = 0;
        } else {
            gatewayEquipmentID = Integer.valueOf(gatewayEquipmentIDtmp);
        }
        if (Objects.equals(gatewayEquipmentName, "") && Objects.equals(personName, "") && gatewayEquipmentID == 0) {
            // All empty
            gatewayBindList = gatewayBindMapper.findAll();
        } else if (Objects.equals(gatewayEquipmentName, "") && Objects.equals(personName, "")) {
            // EID not empty
            gatewayBindList = gatewayBindMapper.findGBByEID(gatewayEquipmentID);
        } else if (Objects.equals(gatewayEquipmentName, "") && gatewayEquipmentID == 0) {
            // PN not empty
            gatewayBindList = gatewayBindMapper.findGBByPN(personName);
        } else if (Objects.equals(personName, "") && gatewayEquipmentID == 0) {
            // GEN not empty
            gatewayBindList = gatewayBindMapper.findGBByGEN(gatewayEquipmentName);
        } else if (Objects.equals(gatewayEquipmentName, "")) {
            // GEN empty
            gatewayBindList = gatewayBindMapper.findGBByPNAndEID(personName, gatewayEquipmentID);
        } else if (Objects.equals(personName, "")) {
            // PN empty
            gatewayBindList = gatewayBindMapper.findGBByEID(gatewayEquipmentID);
        } else if (gatewayEquipmentID == 0) {
            // EID empty
            gatewayBindList = gatewayBindMapper.findGBByGENAndPN(gatewayEquipmentName, personName);
        } else {
            // All not empty
            gatewayBindList = gatewayBindMapper.findGBByPNAndEID(personName, gatewayEquipmentID);
        }
        return gatewayBindList;
    }
}
