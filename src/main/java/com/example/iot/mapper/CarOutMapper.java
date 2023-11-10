package com.example.iot.mapper;

import com.example.iot.relationship.CarOut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarOutMapper {
    @Select("select * from carOutDisplay")        //无条件查询
    public List<CarOut> findAll();

    @Select("select * from carOutDisplay where carOutCarID = #{CarID}")      //根据车牌号查询进场记录
    public List<CarOut> findCarID(String CarID);
}
