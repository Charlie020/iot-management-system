package com.example.iot.mapper;

import com.example.iot.entity.Person;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PersonMapper {
    @Select("select * from communityPerson")
    List<Person> findAll();

    @Select("select * from communityPerson where personID=#{personID}")
    List<Person> findPersonByID(String personID);

    @Select("select * from communityPerson where personName=#{personName}")
    List<Person> findPersonByName(String personName);

    @Select("select * from communityPerson where personType=#{personType}")
    List<Person> findPersonByType(String personType);

    @Select("select * from communityPerson where personPhone=#{personPhone}")
    List<Person> findPersonByPhone(String personPhone);

    @Select("select * from communityPerson where personName=#{personName} and personType=#{personType}")
    List<Person> findPersonByNameAndType(@Param("personName") String personName, @Param("personType") String personType);

    @Insert("insert communityPerson(personID, personName, personPhone, personType, personFace) values (#{personID}, #{personName}, #{personPhone}, #{personType}, #{personFace})")
    void addPerson(Person person);

    @Delete("delete from communityPerson where personID=#{personID}")
    void delPerson(String personID);
}
