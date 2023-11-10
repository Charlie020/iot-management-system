package com.example.iot.mapper;

import com.example.iot.relationship.CarIn;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarInMapper {
    @Select("select * from carInDisplay")        //无条件查询
    public List<CarIn> findAll();

    @Select("select * from carInDisplay where carInCarID = #{CarID}")      //根据车牌号查询进场记录
    public List<CarIn> findCarID(String CarID);
}
