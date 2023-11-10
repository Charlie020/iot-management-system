package com.example.iot.controller;

import com.example.iot.mapper.GatewayOpenRecordMapper;
import com.example.iot.relationship.GatewayOpenRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/gatewayOpenRecord")
public class GatewayOpenRecordController {
    @Autowired
    private GatewayOpenRecordMapper gatewayOpenRecordMapper;

    @GetMapping
    public List<GatewayOpenRecord> findGatewayOpenRecord(@RequestParam(value = "gatewayEquipmentName", required = false) String gatewayEquipmentName,
                                                         @RequestParam(value = "personName", required = false) String personName,
                                                         @RequestParam(value = "gatewayEquipmentID", required = false) String gatewayEquipmentIDtmp) {
        List<GatewayOpenRecord> gatewayOpenRecordList;
        int gatewayEquipmentID;
        if (Objects.equals(gatewayEquipmentIDtmp, "")) {
            gatewayEquipmentID = 0;
        } else {
            gatewayEquipmentID = Integer.valueOf(gatewayEquipmentIDtmp);
        }
        if (Objects.equals(gatewayEquipmentName, "") && Objects.equals(personName, "") && gatewayEquipmentID == 0) {
            // All empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findAll();
        } else if (Objects.equals(gatewayEquipmentName, "") && Objects.equals(personName, "")) {
            // EID not empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByEID(gatewayEquipmentID);
        } else if (Objects.equals(gatewayEquipmentName, "") && gatewayEquipmentID == 0) {
            // PN not empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByPN(personName);
        } else if (Objects.equals(personName, "") && gatewayEquipmentID == 0) {
            // GEN not empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByGEN(gatewayEquipmentName);
        } else if (Objects.equals(gatewayEquipmentName, "")) {
            // GEN empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByPNAndEID(personName, gatewayEquipmentID);
        } else if (Objects.equals(personName, "")) {
            // PN empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByGENAndEID(gatewayEquipmentName, gatewayEquipmentID);
        } else if (gatewayEquipmentID == 0) {
            // EID empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByGENAndPN(gatewayEquipmentName, personName);
        } else {
            // All not empty
            gatewayOpenRecordList = gatewayOpenRecordMapper.findGORByGENAndPNAndEID(gatewayEquipmentName, personName, gatewayEquipmentID);
        }
        return gatewayOpenRecordList;
    }
}
