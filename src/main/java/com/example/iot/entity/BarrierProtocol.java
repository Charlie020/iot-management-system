package com.example.iot.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("barrierProtocol")
public class BarrierProtocol {
    public String barrierProtocolName;
    public String barrierProtocolVersion;
    public String barrierProtocolDeveloper;
    public String barrierProtocolDeveloperPhone;
    public String barrierProtocolProtocolLink;
    public String barrierProtocolState;

    public String getBarrierProtocolName() {
        return barrierProtocolName;
    }

    public void setBarrierProtocolName(String barrierProtocolName) {
        this.barrierProtocolName = barrierProtocolName;
    }

    public String getBarrierProtocolVersion() {
        return barrierProtocolVersion;
    }

    public void setBarrierProtocolVersion(String barrierProtocolVersion) {
        this.barrierProtocolVersion = barrierProtocolVersion;
    }

    public String getBarrierProtocolDeveloper() {
        return barrierProtocolDeveloper;
    }

    public void setBarrierProtocolDeveloper(String barrierProtocolDeveloper) {
        this.barrierProtocolDeveloper = barrierProtocolDeveloper;
    }

    public String getBarrierProtocolDeveloperPhone() {
        return barrierProtocolDeveloperPhone;
    }

    public void setBarrierProtocolDeveloperPhone(String barrierProtocolDeveloperPhone) {
        this.barrierProtocolDeveloperPhone = barrierProtocolDeveloperPhone;
    }

    public String getBarrierProtocolProtocolLink() {
        return barrierProtocolProtocolLink;
    }

    public void setBarrierProtocolProtocolLink(String barrierProtocolProtocolLink) {
        this.barrierProtocolProtocolLink = barrierProtocolProtocolLink;
    }

    public String getBarrierProtocolState() {
        return barrierProtocolState;
    }

    public void setBarrierProtocolState(String barrierProtocolState) {
        this.barrierProtocolState = barrierProtocolState;
    }

    @Override
    public String toString() {
        return "BarrierProtocol{" +
                "barrierProtocolName='" + barrierProtocolName + '\'' +
                ", barrierProtocolVersion='" + barrierProtocolVersion + '\'' +
                ", barrierProtocolDeveloper='" + barrierProtocolDeveloper + '\'' +
                ", barrierProtocolDeveloperPhone='" + barrierProtocolDeveloperPhone + '\'' +
                ", barrierProtocolProtocolLink='" + barrierProtocolProtocolLink + '\'' +
                ", barrierProtocolState='" + barrierProtocolState + '\'' +
                '}';
    }
}
