package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("communityCar")
public class Car {
    private String carID;
    private String carType;
    private String carIsRegistered;
    private String carOwnerID;
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getcarID() {
        return carID;
    }

    public void setcarID(String carID) {
        this.carID = carID;
    }

    public String getcarType() {
        return carType;
    }

    public void setcarType(String carType) {
        this.carType = carType;
    }

    public String getcarIsRegistered() {
        return carIsRegistered;
    }

    public void setcarIsRegistered(String carIsRegistered) {
        this.carIsRegistered = carIsRegistered;
    }

    public String getcarOwnerID() {
        return carOwnerID;
    }

    public void setcarOwnerID(String carOwnerID) {
        this.carOwnerID = carOwnerID;
    }
}
