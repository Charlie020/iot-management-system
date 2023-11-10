package com.example.iot.mapper;

import com.example.iot.entity.GatewayEquipment;
import com.example.iot.entity.Person;
import com.example.iot.relationship.GatewayOpenRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GatewayOpenRecordMapper {
    @Select("select * from gatewayOpenRecord")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findAll();

    @Select("select * from gatewayOpenRecord, gatewayEquipment where gatewayOpenRecordGatewayEquipmentID=gatewayEquipmentID and gatewayOpenRecordGatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByEID(Integer gatewayEquipmentID);

    @Select("select * from gatewayOpenRecord, communityPerson where gatewayOpenRecordPersonID=personID and personName=#{personName}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByPN(String personName);

    @Select("select * from gatewayOpenRecord, gatewayEquipment where gatewayOpenRecordGatewayEquipmentID=gatewayEquipmentID and gatewayEquipmentName=#{gatewayEquipmentName}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByGEN(String gatewayEquipmentName);

    @Select("select * from gatewayOpenRecord, gatewayEquipment, communityPerson where gatewayOpenRecordPersonID=personID and gatewayOpenRecordGatewayEquipmentID=gatewayEquipmentID and " +
            "personName=#{personName} and gatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByPNAndEID(@Param("personName") String personName, @Param("gatewayEquipmentID") Integer gatewayEquipmentID);

    @Select("select * from gatewayOpenRecord, gatewayEquipment where gatewayOpenRecordGatewayEquipmentID=gatewayEquipmentID and " +
            "gatewayEquipmentName=#{gatewayEquipmentName} and gatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByGENAndEID(@Param("gatewayEquipmentName") String gatewayEquipmentName, @Param("gatewayEquipmentID") Integer gatewayEquipmentID);


    @Select("select * from gatewayOpenRecord, gatewayEquipment, communityPerson where gatewayOpenRecordPersonID=personID and gatewayOpenRecordGatewayEquipmentID=gatewayEquipmentID and " +
            "personName=#{personName} and gatewayEquipmentName=#{gatewayEquipmentName}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByGENAndPN(@Param("gatewayEquipmentName") String gatewayEquipmentName, @Param("personName") String personName);

    @Select("select * from gatewayOpenRecord, gatewayEquipment, communityPerson where gatewayOpenRecordPersonID=personID and gatewayOpenRecordGatewayEquipmentID=gatewayEquipmentID and " +
            "personName=#{personName} and gatewayEquipmentName=#{gatewayEquipmentName} and gatewayEquipmentID=#{gatewayEquipmentID}")
    @Results(
            {
                    @Result(column = "gatewayOpenRecordPersonID", property = "gatewayOpenRecordPersonID"),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayOpenRecordGatewayEquipmentID"),
                    @Result(column = "gatewayOpenRecordTime", property = "gatewayOpenRecordTime"),
                    @Result(column = "gatewayOpenPhoto", property = "gatewayOpenPhoto"),
                    @Result(column = "gatewayOpenSimilarity", property = "gatewayOpenSimilarity"),
                    @Result(column = "gatewayOpenRecordPersonID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID")),
                    @Result(column = "gatewayOpenRecordGatewayEquipmentID", property = "gatewayEquipment", javaType = GatewayEquipment.class,
                            many = @Many(select = "com.example.iot.mapper.GatewayEquipmentMapper.findGEByID"))
            }
    )
    List<GatewayOpenRecord> findGORByGENAndPNAndEID(@Param("gatewayEquipmentName") String gatewayEquipmentName, @Param("personName") String personName, @Param("gatewayEquipmentID") Integer gatewayEquipmentID);
}
