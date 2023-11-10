package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("communityPerson")
public class Person {
    private String personID;
    private String personName;
    private String personPhone;
    private String personType;
    private String personFace;
    private String personCreateTime;

    public String getpersonID() {
        return personID;
    }

    public void setpersonID(String personID) {
        this.personID = personID;
    }

    public String getpersonName() {
        return personName;
    }

    public void setpersonName(String personName) {
        this.personName = personName;
    }

    public String getpersonPhone() {
        return personPhone;
    }

    public void setpersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getpersonType() {
        return personType;
    }

    public void setpersonType(String personType) {
        this.personType = personType;
    }

    public String getpersonFace() {
        return personFace;
    }

    public void setpersonFace(String personFace) {
        this.personFace = personFace;
    }

    public String getpersonCreateTime() {
        return personCreateTime;
    }

    public void setpersonCreateTime(String personCreateTime) {
        this.personCreateTime = personCreateTime;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personID='" + personID + '\'' +
                ", personName='" + personName + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", personType='" + personType + '\'' +
                ", personFace='" + personFace + '\'' +
                ", personCreateTime='" + personCreateTime +
                '}';
    }
}
