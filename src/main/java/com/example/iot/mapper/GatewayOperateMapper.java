package com.example.iot.mapper;

import com.example.iot.entity.GatewayEquipment;
import com.example.iot.entity.Person;
import com.example.iot.relationship.GatewayOperate;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface GatewayOperateMapper {
    @Select("select * from gatewayOperate")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findAll();

    @Select("select * from gatewayOperate where gatewayOperateGatewayEquipmentID=#{gatewayOperateGatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByEID(Integer gatewayOperateGatewayEquipmentID);

    @Select("select * from gatewayOperate where gatewayOperateID=#{gatewayOperateID}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByOID(Integer gatewayOperateID);

    @Select("select * from gatewayOperate, gatewayEquipment where gatewayOperateGatewayEquipmentID=gatewayEquipmentID and gatewayEquipmentName=#{gatewayEquipmentName}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByGEN(String gatewayEquipmentName);

    @Select("select * from gatewayOperate where gatewayOperateID=#{gatewayOperateID} and gatewayOperateGatewayEquipmentID=#{gatewayOperateGatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByOIDAndEID(Integer gatewayOperateID, Integer gatewayOperateGatewayEquipmentID);

    @Select("select * from gatewayOperate, gatewayEquipment where gatewayOperateGatewayEquipmentID=gatewayEquipmentID and gatewayEquipmentName=#{gatewayEquipmentName} and gatewayOperateGatewayEquipmentID=#{gatewayOperateGatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByGENAndEID(String gatewayEquipmentName, Integer gatewayOperateGatewayEquipmentID);

    @Select("select * from gatewayOperate, gatewayEquipment where gatewayOperateGatewayEquipmentID=gatewayEquipmentID and gatewayEquipmentName=#{gatewayEquipmentName} and gatewayOperateID=#{gatewayOperateID}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByGENAndOID(String gatewayEquipmentName, Integer gatewayOperateID);

    @Select("select * from gatewayOperate, gatewayEquipment where gatewayOperateGatewayEquipmentID=gatewayEquipmentID and gatewayEquipmentName=#{gatewayEquipmentName} and gatewayOperateID=#{gatewayOperateID} and gatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOperateID", property = "gatewayOperateID"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayOperateGatewayEquipmentID"),
                    @Result(column = "gatewayOperateType", property = "gatewayOperateType"),
                    @Result(column = "gatewayOperateDescription", property = "gatewayOperateDescription"),
                    @Result(column = "gatewayOperatePersonID", property = "gatewayOperatePersonID"),
                    @Result(column = "gatewayOperateState", property = "gatewayOperateState"),
                    @Result(column = "gatewayOperateCreateTime", property = "gatewayOperateCreateTime"),
                    @Result(column = "gatewayOperateGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID")),
                    @Result(column = "gatewayOperatePersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<GatewayOperate> findGOByGENAndOIDAndEID(String gatewayEquipmentName, Integer gatewayOperateID, Integer gatewayEquipmentID);
}