package com.example.iot.relationship;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.iot.entity.GatewayEquipment;
import com.example.iot.entity.Person;

@TableName("gatewayOperate")
public class GatewayOperate {
    private Integer gatewayOperateID;
    private String gatewayOperateGatewayEquipmentID;
    private String gatewayOperateType;
    private String gatewayOperateDescription;
    private String gatewayOperatePersonID;
    private String gatewayOperateState;
    private String gatewayOperateCreateTime;
    private GatewayEquipment gatewayEquipment;
    private Person person;

    public Integer getGatewayOperateID() {
        return gatewayOperateID;
    }

    public void setGatewayOperateID(Integer gatewayOperateID) {
        this.gatewayOperateID = gatewayOperateID;
    }

    public String getGatewayOperateGatewayEquipmentID() {
        return gatewayOperateGatewayEquipmentID;
    }

    public void setGatewayOperateGatewayEquipmentID(String gatewayOperateGatewayEquipmentID) {
        this.gatewayOperateGatewayEquipmentID = gatewayOperateGatewayEquipmentID;
    }

    public String getGatewayOperateType() {
        return gatewayOperateType;
    }

    public void setGatewayOperateType(String gatewayOperateType) {
        this.gatewayOperateType = gatewayOperateType;
    }

    public String getGatewayOperateDescription() {
        return gatewayOperateDescription;
    }

    public void setGatewayOperateDescription(String gatewayOperateDescription) {
        this.gatewayOperateDescription = gatewayOperateDescription;
    }

    public String getGatewayOperatePersonID() {
        return gatewayOperatePersonID;
    }

    public void setGatewayOperatePersonID(String gatewayOperatePersonID) {
        this.gatewayOperatePersonID = gatewayOperatePersonID;
    }

    public String getGatewayOperateState() {
        return gatewayOperateState;
    }

    public void setGatewayOperateState(String gatewayOperateState) {
        this.gatewayOperateState = gatewayOperateState;
    }

    public String getGatewayOperateCreateTime() {
        return gatewayOperateCreateTime;
    }

    public void setGatewayOperateCreateTime(String gatewayOperateCreateTime) {
        this.gatewayOperateCreateTime = gatewayOperateCreateTime;
    }

    public GatewayEquipment getGatewayEquipment() {
        return gatewayEquipment;
    }

    public void setGatewayEquipment(GatewayEquipment gatewayEquipment) {
        this.gatewayEquipment = gatewayEquipment;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
