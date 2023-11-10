package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("parkingLot")
public class ParkingLot {
    private String parkingLotID;
    private String parkingLotCreateTime;

    public String getparkingLotID() {
        return parkingLotID;
    }

    public void setparkingLotID(String parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public String getparkingLotCreateTime() {
        return parkingLotCreateTime;
    }

    public void setparkingLotCreateTime(String parkingLotCreateTime) {
        this.parkingLotCreateTime = parkingLotCreateTime;
    }
}
