package com.example.iot.relationship;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.iot.entity.GatewayEquipment;
import com.example.iot.entity.Person;

@TableName("gatewayOpenRecord")
public class GatewayOpenRecord {
    private String gatewayOpenRecordPersonID;
    private String gatewayOpenRecordGatewayEquipmentID;
    private String gatewayOpenRecordTime;
    private String gatewayOpenPhoto;
    private Integer gatewayOpenSimilarity;
    private Person person;
    private GatewayEquipment gatewayEquipment;

    public String getGatewayOpenRecordPersonID() {
        return gatewayOpenRecordPersonID;
    }

    public void setGatewayOpenRecordPersonID(String gatewayOpenRecordPersonID) {
        this.gatewayOpenRecordPersonID = gatewayOpenRecordPersonID;
    }

    public String getGatewayOpenRecordGatewayEquipmentID() {
        return gatewayOpenRecordGatewayEquipmentID;
    }

    public void setGatewayOpenRecordGatewayEquipmentID(String gatewayOpenRecordGatewayEquipmentID) {
        this.gatewayOpenRecordGatewayEquipmentID = gatewayOpenRecordGatewayEquipmentID;
    }

    public String getGatewayOpenRecordTime() {
        return gatewayOpenRecordTime;
    }

    public void setGatewayOpenRecordTime(String gatewayOpenRecordTime) {
        this.gatewayOpenRecordTime = gatewayOpenRecordTime;
    }

    public String getGatewayOpenPhoto() {
        return gatewayOpenPhoto;
    }

    public void setGatewayOpenPhoto(String gatewayOpenPhoto) {
        this.gatewayOpenPhoto = gatewayOpenPhoto;
    }

    public Integer getGatewayOpenSimilarity() {
        return gatewayOpenSimilarity;
    }

    public void setGatewayOpenSimilarity(Integer gatewayOpenSimilarity) {
        this.gatewayOpenSimilarity = gatewayOpenSimilarity;
    }

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
}
