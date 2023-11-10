package com.example.iot.mapper;

import com.example.iot.entity.GatewayEquipment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GatewayEquipmentMapper {
    @Select("select * from gatewayEquipment")
    List<GatewayEquipment> findAll();

    @Select("select * from gatewayEquipment where gatewayEquipmentMacAddress=#{gatewayEquipmentMacAddress}")
    List<GatewayEquipment> findGEByMacAddress(String gatewayEquipmentMacAddress);

    @Select("select * from gatewayEquipment where gatewayEquipmentName=#{gatewayEquipmentName}")
    List<GatewayEquipment> findGEByName(String gatewayEquipmentName);

    @Select("select * from gatewayEquipment where gatewayEquipmentIP=#{gatewayEquipmentIP}")
    List<GatewayEquipment> findGEByIP(String gatewayEquipmentIP);

    @Select("select * from gatewayEquipment where gatewayEquipmentID=#{gatewayEquipmentID}")
    List<GatewayEquipment> findGEByID(Integer gatewayEquipmentID);

    @Select("select * from gatewayEquipment where gatewayEquipmentIP=#{gatewayEquipmentIP} and gatewayEquipmentMacAddress=#{gatewayEquipmentMacAddress}")
    List<GatewayEquipment> findGEByIPAndMac(@Param("gatewayEquipmentIP") String gatewayEquipmentIP , @Param("gatewayEquipmentMacAddress") String gatewayEquipmentMacAddress);

    @Select("select * from gatewayEquipment where gatewayEquipmentID=#{gatewayEquipmentID} and gatewayEquipmentMacAddress=#{gatewayEquipmentMacAddress}")
    List<GatewayEquipment> findGEByIDAndMac(@Param("gatewayEquipmentID") Integer gatewayEquipmentID, @Param("gatewayEquipmentMacAddress") String gatewayEquipmentMacAddress);

    @Select("select * from gatewayEquipment where gatewayEquipmentID=#{gatewayEquipmentID} and gatewayEquipmentIP=#{gatewayEquipmentIP}")
    List<GatewayEquipment> findGEByIDAndIP(@Param("gatewayEquipmentID") Integer gatewayEquipmentID, @Param("gatewayEquipmentIP") String gatewayEquipmentIP);

    @Select("select * from gatewayEquipment where gatewayEquipmentID=#{gatewayEquipmentID} and gatewayEquipmentIP=#{gatewayEquipmentIP} and gatewayEquipmentMacAddress=#{gatewayEquipmentMacAddress}")
    List<GatewayEquipment> findGEByIDIPMac(@Param("gatewayEquipmentID") Integer gatewayEquipmentID, @Param("gatewayEquipmentIP") String gatewayEquipmentIP, @Param("gatewayEquipmentMacAddress") String gatewayEquipmentMacAddress);

    @Insert("insert into gatewayEquipment(gatewayEquipmentName, gatewayEquipmentIP, gatewayEquipmentIPVersion, gatewayEquipmentMacAddress, gatewayEquipmentBrand) " +
            " values (#{gatewayEquipmentName}, #{gatewayEquipmentIP}, #{gatewayEquipmentIPVersion}, #{gatewayEquipmentMacAddress}, #{gatewayEquipmentBrand})")
    void addGatewayEquipment(GatewayEquipment gatewayEquipment);

    @Delete("delete from gatewayEquipment where gatewayEquipmentID=#{gatewayEquipmentID}")
    void delGatewayEquipment(Integer gatewayEquipmentID);
}
