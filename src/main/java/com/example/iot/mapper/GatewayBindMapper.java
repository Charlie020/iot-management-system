package com.example.iot.mapper;

import com.example.iot.entity.GatewayEquipment;
import com.example.iot.entity.Person;
import com.example.iot.relationship.GatewayBind;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GatewayBindMapper {
    @Select("select * from gatewayBind")
    @Results(
            {
                    @Result(column = "gatewayBindPersonID", property = "gatewayBindPersonID"),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayBindGatewayEquipmentID"),
                    @Result(column = "gatewayBindState", property = "gatewayBindState"),
                    @Result(column = "gatewayBindDescription", property = "gatewayBindDescription"),
                    @Result(column = "gatewayBindCreateTime", property = "gatewayBindCreateTime"),
                    @Result(column = "gatewayBindPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayBind> findAll();

    @Select("select * from gatewayBind where gatewayBindGatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayBindPersonID", property = "gatewayBindPersonID"),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayBindGatewayEquipmentID"),
                    @Result(column = "gatewayBindState", property = "gatewayBindState"),
                    @Result(column = "gatewayBindDescription", property = "gatewayBindDescription"),
                    @Result(column = "gatewayBindCreateTime", property = "gatewayBindCreateTime"),
                    @Result(column = "gatewayBindPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayBind> findGBByEID(Integer gatewayEquipmentID);

    @Select("select * from gatewayBind, communityPerson where gatewayBindPersonID=personID and personName=#{personName}")
    @Results(
            {
                    @Result(column = "gatewayBindPersonID", property = "gatewayBindPersonID"),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayBindGatewayEquipmentID"),
                    @Result(column = "gatewayBindState", property = "gatewayBindState"),
                    @Result(column = "gatewayBindDescription", property = "gatewayBindDescription"),
                    @Result(column = "gatewayBindCreateTime", property = "gatewayBindCreateTime"),
                    @Result(column = "gatewayBindPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayBind> findGBByPN(String personName);

    @Select("select * from gatewayBind, gatewayEquipment where gatewayBindGatewayEquipmentID=gatewayEquipmentID and gatewayEquipmentName=#{gatewayEquipmentName}")
    @Results(
            {
                    @Result(column = "gatewayBindPersonID", property = "gatewayBindPersonID"),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayBindGatewayEquipmentID"),
                    @Result(column = "gatewayBindState", property = "gatewayBindState"),
                    @Result(column = "gatewayBindDescription", property = "gatewayBindDescription"),
                    @Result(column = "gatewayBindCreateTime", property = "gatewayBindCreateTime"),
                    @Result(column = "gatewayBindPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayBind> findGBByGEN(String gatewayEquipmentName);

    @Select("select * from gatewayBind, communityPerson, gatewayEquipment where " +
            "gatewayBindGatewayEquipmentID=gatewayEquipmentID and gatewayBindPersonID=personID and personName=#{personName} and gatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayBindPersonID", property = "gatewayBindPersonID"),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayBindGatewayEquipmentID"),
                    @Result(column = "gatewayBindState", property = "gatewayBindState"),
                    @Result(column = "gatewayBindDescription", property = "gatewayBindDescription"),
                    @Result(column = "gatewayBindCreateTime", property = "gatewayBindCreateTime"),
                    @Result(column = "gatewayBindPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayBind> findGBByPNAndEID(@Param("personName") String personName, @Param("gatewayEquipmentID") Integer gatewayEquipmentID);

    @Select("select * from gatewayBind, communityPerson, gatewayEquipment where " +
            "gatewayBindGatewayEquipmentID=gatewayEquipmentID and gatewayBindPersonID=personID and personName=#{personName} and gatewayEquipmentName=#{gatewayEquipmentName}")
    @Results(
            {
                    @Result(column = "gatewayBindPersonID", property = "gatewayBindPersonID"),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayBindGatewayEquipmentID"),
                    @Result(column = "gatewayBindState", property = "gatewayBindState"),
                    @Result(column = "gatewayBindDescription", property = "gatewayBindDescription"),
                    @Result(column = "gatewayBindCreateTime", property = "gatewayBindCreateTime"),
                    @Result(column = "gatewayBindPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayBindGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayBind> findGBByGENAndPN(@Param("gatewayEquipmentName") String gatewayEquipmentName, @Param("personName") String personName);


}
