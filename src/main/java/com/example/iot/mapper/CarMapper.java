package com.example.iot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.iot.entity.Car;
import com.example.iot.entity.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CarMapper extends BaseMapper<Car> {
    @Select("select * from communityCar, communityPerson where carOwnerID=personID")
    @Results(
            {
                    @Result(column = "carID", property = "carID"),
                    @Result(column = "carType", property = "carType"),
                    @Result(column = "carIsRegistered", property = "carIsRegistered"),
                    @Result(column = "carOwnerID", property = "carOwnerID"),
                    @Result(column = "carOwnerID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<Car> findAll();

    @Select("select * from communityCar, communityPerson where carOwnerID=personID and carID=#{carID}")
    @Results(
            {
                    @Result(column = "carID", property = "carID"),
                    @Result(column = "carType", property = "carType"),
                    @Result(column = "carIsRegistered", property = "carIsRegistered"),
                    @Result(column = "carOwnerID", property = "carOwnerID"),
                    @Result(column = "carOwnerID", property = "person", javaType = Person.class,
                            many = @Many(select = "com.example.iot.mapper.PersonMapper.findPersonByID"))
            }
    )
    List<Car> findCarByID(String carID);

    @Insert("insert into communityCar values(#{carID}, #{carType}, #{carIsRegistered}, #{carOwnerID})")
    void addCar(Car car);

    @Delete("delete from communityCar where carID=#{carID}")
    void delCar(String carID);
}
