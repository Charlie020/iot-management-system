package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("gatewayEquipment")
public class GatewayEquipment {
    private Integer gatewayEquipmentID;
    private String gatewayEquipmentName;
    private String gatewayEquipmentIP;
    private String gatewayEquipmentIPVersion;
    private String gatewayEquipmentMacAddress;
    private String gatewayEquipmentBrand;

    public Integer getGatewayEquipmentID() {
        return gatewayEquipmentID;
    }

    public void setGatewayEquipmentID(Integer gatewayEquipmentID) {
        this.gatewayEquipmentID = gatewayEquipmentID;
    }

    public String getGatewayEquipmentName() {
        return gatewayEquipmentName;
    }

    public void setGatewayEquipmentName(String gatewayEquipmentName) {
        this.gatewayEquipmentName = gatewayEquipmentName;
    }

    public String getGatewayEquipmentIP() {
        return gatewayEquipmentIP;
    }

    public void setGatewayEquipmentIP(String gatewayEquipmentIP) {
        this.gatewayEquipmentIP = gatewayEquipmentIP;
    }

    public String getGatewayEquipmentIPVersion() {
        return gatewayEquipmentIPVersion;
    }

    public void setGatewayEquipmentIPVersion(String gatewayEquipmentIPVersion) {
        this.gatewayEquipmentIPVersion = gatewayEquipmentIPVersion;
    }

    public String getGatewayEquipmentMacAddress() {
        return gatewayEquipmentMacAddress;
    }

    public void setGatewayEquipmentMacAddress(String gatewayEquipmentMacAddress) {
        this.gatewayEquipmentMacAddress = gatewayEquipmentMacAddress;
    }

    public String getGatewayEquipmentBrand() {
        return gatewayEquipmentBrand;
    }

    public void setGatewayEquipmentBrand(String gatewayEquipmentBrand) {
        this.gatewayEquipmentBrand = gatewayEquipmentBrand;
    }

    @Override
    public String toString() {
        return "GatewayEquipment{" +
                "gatewayEquipmentID=" + gatewayEquipmentID +
                ", gatewayEquipmentName='" + gatewayEquipmentName + '\'' +
                ", gatewayEquipmentIP='" + gatewayEquipmentIP + '\'' +
                ", gatewayEquipmentIPVersion='" + gatewayEquipmentIPVersion + '\'' +
                ", gatewayEquipmentMacAddress='" + gatewayEquipmentMacAddress + '\'' +
                ", gatewayEquipmentBrand='" + gatewayEquipmentBrand + '\'' +
                '}';
    }
}
