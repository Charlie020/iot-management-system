package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("barrierEquipment")
public class BarrierEquipment {
    public int barrierEquipmentID;
    public String barrierEquipmentName;
    public String barrierEquipmentDirection;
    public String barrierEquipmentIP;
    public String barrierEquipmentIPVersion;
    public String barrierEquipmentMacAddress;
    public String barrierEquipmentProtocol;

    public int getBarrierEquipmentID() {
        return barrierEquipmentID;
    }

    public void setBarrierEquipmentID(int barrierEquipmentID) {
        this.barrierEquipmentID = barrierEquipmentID;
    }

    public String getBarrierEquipmentName() {
        return barrierEquipmentName;
    }

    public void setBarrierEquipmentName(String barrierEquipmentName) {
        this.barrierEquipmentName = barrierEquipmentName;
    }

    public String getBarrierEquipmentDirection() {
        return barrierEquipmentDirection;
    }

    public void setBarrierEquipmentDirection(String barrierEquipmentDirection) {
        this.barrierEquipmentDirection = barrierEquipmentDirection;
    }

    public String getBarrierEquipmentIP() {
        return barrierEquipmentIP;
    }

    public void setBarrierEquipmentIP(String barrierEquipmentIP) {
        this.barrierEquipmentIP = barrierEquipmentIP;
    }

    public String getBarrierEquipmentIPVersion() {
        return barrierEquipmentIPVersion;
    }

    public void setBarrierEquipmentIPVersion(String barrierEquipmentIPVersion) {
        this.barrierEquipmentIPVersion = barrierEquipmentIPVersion;
    }

    public String getBarrierEquipmentMacAddress() {
        return barrierEquipmentMacAddress;
    }

    public void setBarrierEquipmentMacAddress(String barrierEquipmentMacAddress) {
        this.barrierEquipmentMacAddress = barrierEquipmentMacAddress;
    }

    public String getBarrierEquipmentProtocol() {
        return barrierEquipmentProtocol;
    }

    public void setBarrierEquipmentProtocol(String barrierEquipmentProtocol) {
        this.barrierEquipmentProtocol = barrierEquipmentProtocol;
    }

    @Override
    public String toString() {
        return "BarrierEquipment{" +
                "barrierEquipmentID='" + barrierEquipmentID + '\'' +
                ", barrierEquipmentName='" + barrierEquipmentName + '\'' +
                ", barrierEquipmentDirection='" + barrierEquipmentDirection + '\'' +
                ", barrierEquipmentIP='" + barrierEquipmentIP + '\'' +
                ", barrierEquipmentIPVersion='" + barrierEquipmentIPVersion + '\'' +
                ", barrierEquipmentMacAddress='" + barrierEquipmentMacAddress + '\'' +
                ", barrierEquipmentProtocol='" + barrierEquipmentProtocol + '\'' +
                '}';
    }
}
