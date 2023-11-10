package com.example.iot.mapper;

import com.example.iot.entity.ParkingSpace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface ParkingSpaceMapper {
    @Select("select * from parkingSpace")
    List<ParkingSpace> findAll();

    @Select("select * from parkingSpace where parkingSpaceID=#{parkingSpaceID}")
    List<ParkingSpace> findByparkingSpaceID(String parkingSpaceID);

    @Insert("insert into parkingSpace (parkingSpaceID, parkingSpaceParkingLotID, parkingSpaceCarID) values(#{parkingSpaceID}, #{parkingSpaceParkingLotID}, #{parkingSpaceCarID})")
    void addParkingSpace(ParkingSpace parkingSpace);

    @Delete("delete from parkingSpace where parkingSpaceID=#{parkingSpaceID}")
    void delParkingSpace(String parkingSpaceID);
}
