package com.example.iot.mapper;

import com.example.iot.entity.BarrierEquipment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BarrierEquipmentMapper {
    @Select("select * from barrierEquipment")
    public List<BarrierEquipment> findNoCondition();

    @Select("select * from barrierEquipment where barrierEquipmentID = #{id}")
    public List<BarrierEquipment> findId(int id);

    @Select("select * from barrierEquipment where barrierEquipmentIP = #{ip}")
    public List<BarrierEquipment> findIP(String ip);

    @Select("select * from barrierEquipment where barrierEquipmentMacAddress = #{mac}")
    public List<BarrierEquipment> findMac(String mac);

    @Select("select * from barrierEquipment where barrierEquipmentID = #{id} and barrierEquipmentIP = #{ip}")
    public List<BarrierEquipment> findIdIP(int id, String ip);

    @Select("select * from barrierEquipment where barrierEquipmentID = #{id} and barrierEquipmentMacAddress = #{mac}")
    public List<BarrierEquipment> findIdMac(int id, String mac);

    @Select("select * from barrierEquipment where barrierEquipmentIP = #{ip} and barrierEquipmentMacAddress = #{mac}")
    public List<BarrierEquipment> findIPMac(String ip, String mac);

    @Select("select * from barrierEquipment where barrierEquipmentID = #{id} and barrierEquipmentIP = #{ip} and barrierEquipmentMacAddress = #{mac}")
    public List<BarrierEquipment> findIdIPMac(int id, String ip, String mac);

    @Select("select * from barrierEquipment where barrierEquipmentName = #{Name}")
    public List<BarrierEquipment> findName(String Name);

    // 验证外键约束的辅助查找方法
    @Select("select barrierProtocolName from barrierProtocol")
    public List<String> foreignKey();

    // 验证道闸协议是否启用
    @Select("select barrierProtocolState from barrierProtocol where barrierProtocolName=#{Name}")
    public String idUsed(String Name);

    // 插入道闸
    @Insert("INSERT INTO barrierEquipment (barrierEquipmentName, barrierEquipmentDirection, barrierEquipmentIP, " +
            "barrierEquipmentIPVersion, barrierEquipmentMacAddress, barrierEquipmentProtocol) VALUES (#{barrierEquipmentName}," +
            "#{barrierEquipmentDirection}, #{barrierEquipmentIP},#{barrierEquipmentIPVersion},#{barrierEquipmentMacAddress}," +
            "#{barrierEquipmentProtocol})")
    public int insert(BarrierEquipment barrierEquipment);

    //删除道闸
    @Delete("delete from barrierEquipment where barrierEquipmentID = #{id}")
    public int delete(int id);
}
