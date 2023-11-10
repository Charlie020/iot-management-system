package com.example.iot.mapper;

import com.example.iot.entity.BarrierProtocol;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BarrierProtocolMapper {
    @Select("select * from barrierProtocol")        //无条件查询
    public List<BarrierProtocol> find1();

    @Select("select * from barrierProtocol where barrierProtocolName = #{Name}")      //根据厂商名称查询
    public List<BarrierProtocol> find2(String Name);

    @Select("select * from barrierProtocol where barrierProtocolProtocolLink = #{Link}")      //根据厂商链接查询
    public List<BarrierProtocol> findLink(String Link);

    @Insert("INSERT INTO barrierProtocol VALUES (#{barrierProtocolName},#{barrierProtocolVersion},#{barrierProtocolDeveloper}, " +
            "#{barrierProtocolDeveloperPhone},#{barrierProtocolProtocolLink},#{barrierProtocolState})")
    public int insert(BarrierProtocol barrierProtocol);         //插入道闸协议

    // 禁用=》启用
    @Update("update barrierProtocol set barrierProtocolState = '启用' where barrierProtocolName = #{Name}")
    public int startUse(String Name);

    // 启用=》禁用
    @Update("update barrierProtocol set barrierProtocolState = '禁用' where barrierProtocolName = #{Name}")
    public int startUnUse(String Name);

    @Delete("delete from barrierProtocol where barrierProtocolName = #{Name}")
    public int delete(String Name);
}
