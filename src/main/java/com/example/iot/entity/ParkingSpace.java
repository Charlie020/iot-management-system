package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("parkingSpace")
public class ParkingSpace {
    private String parkingSpaceID;
    private String parkingSpaceCreateTime;
    private String parkingSpaceParkingLotID;
    private String parkingSpaceCarID;

    public String getparkingSpaceID() {
        return parkingSpaceID;
    }

    public void setparkingSpaceID(String parkingSpaceID) {
        this.parkingSpaceID = parkingSpaceID;
    }

    public String getparkingSpaceCreateTime() {
        return parkingSpaceCreateTime;
    }

    public void setparkingSpaceCreateTime(String parkingSpaceCreateTime) {
        this.parkingSpaceCreateTime = parkingSpaceCreateTime;
    }

    public String getparkingSpaceParkingLotID() {
        return parkingSpaceParkingLotID;
    }

    public void setparkingSpaceParkingLotID(String parkingSpaceParkingLotID) {
        this.parkingSpaceParkingLotID = parkingSpaceParkingLotID;
    }

    public String getparkingSpaceCarID() {
        return parkingSpaceCarID;
    }

    public void setparkingSpaceCarID(String parkingSpaceCarID) {
        this.parkingSpaceCarID = parkingSpaceCarID;
    }
}
