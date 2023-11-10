package com.example.iot.mapper;

import com.example.iot.entity.Car;
import com.example.iot.relationship.CarIn;
import com.example.iot.relationship.CarOut;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ControlCenterMapper {
    @Select("select * from communityCar where carID = #{ID}")        //无条件查询
    public List<Car> findCar(String ID);

    @Select("select barrierEquipmentID from barrierEquipment")
    public List<Integer> foreignKey();

    @Insert("insert into communityCar (carID, carType, carIsRegistered) values (#{carID}, #{carType}, '2')")
    public int insertCar(String carID, String carType);

    @Insert("insert into carIn (carInID, carInBarrierEquipmentID, carInCarID, carInDescription) values (#{carInID}, " +
            "#{carInBarrierEquipmentID}, #{carInCarID}, #{carInDescription})")
    public int insertCarIn(CarIn carIn);

    @Insert("insert into carOut (carOutID, carOutBarrierEquipmentID, carOutCarID, carOutDescription, carOutMoneyReceivable, " +
            "carOutMoneyLast) values (#{carOutID},#{carOutBarrierEquipmentID}, #{carOutCarID}, #{carOutDescription}, " +
            "#{carOutMoneyReceivable}, #{carOutMoneyLast})")
    public int insertCarOut(CarOut carOut);
}
