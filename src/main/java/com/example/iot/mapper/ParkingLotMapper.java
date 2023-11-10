package com.example.iot.mapper;

import com.example.iot.entity.ParkingLot;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ParkingLotMapper {
    @Select("select * from parkingLot")
    List<ParkingLot> findAll();

    @Select("select * from parkingLot where parkingLotID=#{parkingLotID}")
    List<ParkingLot> findParkingLotByID(String parkingLotID);

    @Insert("insert parkingLot (parkingLotID) values (#{parkingLotID})")
    void addParkingLot(ParkingLot parkingLot);

    @Delete("delete from parkingLot where parkingLotID=#{parkingLotID}")
    void delParkingLot(String parkingLotID);
}
