package com.example.iot.relationship;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.iot.entity.GatewayEquipment;
import com.example.iot.entity.Person;

@TableName("gatewayBind")
public class GatewayBind {
    private String gatewayBindPersonID;
    private String gatewayBindGatewayEquipmentID;
    private String gatewayBindState;
    private String gatewayBindDescription;
    private String gatewayBindCreateTime;
    private Person person;
    private GatewayEquipment gatewayEquipment;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public GatewayEquipment getGatewayEquipment() {
        return gatewayEquipment;
    }

    public void setGatewayEquipment(GatewayEquipment gatewayEquipment) {
        this.gatewayEquipment = gatewayEquipment;
    }

    public String getGatewayBindPersonID() {
        return gatewayBindPersonID;
    }

    public void setGatewayBindPersonID(String gatewayBindPersonID) {
        this.gatewayBindPersonID = gatewayBindPersonID;
    }

    public String getGatewayBindGatewayEquipmentID() {
        return gatewayBindGatewayEquipmentID;
    }

    public void setGatewayBindGatewayEquipmentID(String gatewayBindGatewayEquipmentID) {
        this.gatewayBindGatewayEquipmentID = gatewayBindGatewayEquipmentID;
    }

    public String getGatewayBindState() {
        return gatewayBindState;
    }

    public void setGatewayBindState(String gatewayBindState) {
        this.gatewayBindState = gatewayBindState;
    }

    public String getGatewayBindDescription() {
        return gatewayBindDescription;
    }

    public void setGatewayBindDescription(String gatewayBindDescription) {
        this.gatewayBindDescription = gatewayBindDescription;
    }

    public String getGatewayBindCreateTime() {
        return gatewayBindCreateTime;
    }

    public void setGatewayBindCreateTime(String gatewayBindCreateTime) {
        this.gatewayBindCreateTime = gatewayBindCreateTime;
    }
}
