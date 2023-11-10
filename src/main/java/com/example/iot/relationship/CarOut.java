package com.example.iot.relationship;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("carOut")
public class CarOut {
    public int carOutID;
    public int carOutBarrierEquipmentID;
    public String carOutCarID;
    public String carOutTime;
    public String carOutDescription;
    public double carOutMoneyReceivable;
    public double carOutMoneyLast;

    // 此属性不在数据库中 仅传参用
    public String carOutCarType;

    public int getCarOutID() {
        return carOutID;
    }

    public void setCarOutID(int carOutID) {
        this.carOutID = carOutID;
    }

    public int getCarOutBarrierEquipmentID() {
        return carOutBarrierEquipmentID;
    }

    public void setCarOutBarrierEquipmentID(int carOutBarrierEquipmentID) {
        this.carOutBarrierEquipmentID = carOutBarrierEquipmentID;
    }

    public String getCarOutCarID() {
        return carOutCarID;
    }

    public void setCarOutCarID(String carOutCarID) {
        this.carOutCarID = carOutCarID;
    }

    public String getCarOutTime() {
        return carOutTime;
    }

    public void setCarOutTime(String carOutTime) {
        this.carOutTime = carOutTime;
    }

    public String getCarOutDescription() {
        return carOutDescription;
    }

    public void setCarOutDescription(String carOutDescription) {
        this.carOutDescription = carOutDescription;
    }

    public double getCarOutMoneyReceivable() {
        return carOutMoneyReceivable;
    }

    public void setCarOutMoneyReceivable(double carOutMoneyReceivable) {
        this.carOutMoneyReceivable = carOutMoneyReceivable;
    }

    public double getCarOutMoneyLast() {
        return carOutMoneyLast;
    }

    public void setCarOutMoneyLast(double carOutMoneyLast) {
        this.carOutMoneyLast = carOutMoneyLast;
    }

    @Override
    public String toString() {
        return "CarOut{" +
                "carOutID=" + carOutID +
                ", carOutBarrierEquipmentID=" + carOutBarrierEquipmentID +
                ", carOutCarID='" + carOutCarID + '\'' +
                ", carOutTime='" + carOutTime + '\'' +
                ", carOutDescription='" + carOutDescription + '\'' +
                ", carOutMoneyReceivable=" + carOutMoneyReceivable +
                ", carOutMoneyLast=" + carOutMoneyLast +
                '}';
    }
}
