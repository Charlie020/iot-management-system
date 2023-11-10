package com.example.iot.controller;

import com.example.iot.mapper.GatewayOperateMapper;
import com.example.iot.relationship.GatewayOperate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/gatewayOperate")
public class GatewayOperateController {
    @Autowired
    private GatewayOperateMapper gatewayOperateMapper;

    @GetMapping
    public List<GatewayOperate> findGatewayOperate(@RequestParam(value = "gatewayEquipmentName", required = false) String gatewayEquipmentName,
                                                   @RequestParam(value = "gatewayOperateID", required = false) String gatewayOperateIDtmp,
                                                   @RequestParam(value = "gatewayOperateGatewayEquipmentID", required = false) String gatewayOperateGatewayEquipmentIDtmp) {
        List<GatewayOperate> gatewayOperateList;
        int gatewayOperateID;
        if (Objects.equals(gatewayOperateIDtmp, "")) {
            gatewayOperateID = 0;
        } else {
            gatewayOperateID = Integer.valueOf(gatewayOperateIDtmp);
        }
        int gatewayOperateGatewayEquipmentID;
        if (Objects.equals(gatewayOperateGatewayEquipmentIDtmp, "")) {
            gatewayOperateGatewayEquipmentID = 0;
        } else {
            gatewayOperateGatewayEquipmentID = Integer.valueOf(gatewayOperateGatewayEquipmentIDtmp);
        }
        
        if (Objects.equals(gatewayEquipmentName, "") && gatewayOperateID == 0 && gatewayOperateGatewayEquipmentID == 0) {
            // All empty
            gatewayOperateList = gatewayOperateMapper.findAll();
        } else if (Objects.equals(gatewayEquipmentName, "") && gatewayOperateID == 0) {
            // EID not empty
            gatewayOperateList = gatewayOperateMapper.findGOByEID(gatewayOperateGatewayEquipmentID);
        } else if (Objects.equals(gatewayEquipmentName, "") && gatewayOperateGatewayEquipmentID == 0) {
            // OID not empty
            gatewayOperateList = gatewayOperateMapper.findGOByOID(gatewayOperateID);
        } else if (gatewayOperateID == 0 && gatewayOperateGatewayEquipmentID == 0) {
            // GEN not empty
            gatewayOperateList = gatewayOperateMapper.findGOByGEN(gatewayEquipmentName);
        } else if (Objects.equals(gatewayEquipmentName, "")) {
            // GEN empty
            gatewayOperateList = gatewayOperateMapper.findGOByOIDAndEID(gatewayOperateID, gatewayOperateGatewayEquipmentID);
        } else if (gatewayOperateID == 0) {
            // OID empty
            gatewayOperateList = gatewayOperateMapper.findGOByGENAndEID(gatewayEquipmentName, gatewayOperateGatewayEquipmentID);
        } else if (gatewayOperateGatewayEquipmentID == 0) {
            // EID empty
            gatewayOperateList = gatewayOperateMapper.findGOByGENAndOID(gatewayEquipmentName, gatewayOperateID);
        } else {
            // All not empty
            gatewayOperateList = gatewayOperateMapper.findGOByGENAndOIDAndEID(gatewayEquipmentName, gatewayOperateID, gatewayOperateGatewayEquipmentID);
        }
        return gatewayOperateList;
    }
}
