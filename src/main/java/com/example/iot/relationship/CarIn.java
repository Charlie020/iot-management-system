package com.example.iot.relationship;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("carIn")
public class CarIn {
    public int carInID;
    public int carInBarrierEquipmentID;
    public String carInCarID;
    public String carInTime;
    public String carInDescription;

    // 此属性不在数据库中 仅传参用
    public String carInCarType;
    public int getCarInID() {
        return carInID;
    }

    public void setCarInID(int carInID) {
        this.carInID = carInID;
    }

    public int getCarInBarrierEquipmentID() {
        return carInBarrierEquipmentID;
    }

    public void setCarInBarrierEquipmentID(int carInBarrierEquipmentID) {
        this.carInBarrierEquipmentID = carInBarrierEquipmentID;
    }

    public String getCarInCarID() {
        return carInCarID;
    }

    public void setCarInCarID(String carInCarID) {
        this.carInCarID = carInCarID;
    }

    public String getCarInTime() {
        return carInTime;
    }

    public void setCarInTime(String carInTime) {
        this.carInTime = carInTime;
    }

    public String getCarInDescription() {
        return carInDescription;
    }

    public void setCarInDescription(String carInDescription) {
        this.carInDescription = carInDescription;
    }

    public String getCarInCarType() {
        return carInCarType;
    }

    public void setCarInCarType(String carInCarType) {
        this.carInCarType = carInCarType;
    }

    @Override
    public String toString() {
        return "CarIn{" +
                "carInID=" + carInID +
                ", carInBarrierEquipmentID=" + carInBarrierEquipmentID +
                ", carInCarID='" + carInCarID + '\'' +
                ", carInTime='" + carInTime + '\'' +
                ", carInDescription='" + carInDescription + '\'' +
                ", carInCarType='" + carInCarType + '\'' +
                '}';
    }
}
