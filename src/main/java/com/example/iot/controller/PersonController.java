package com.example.iot.controller;

import com.example.iot.entity.Person;
import com.example.iot.mapper.PersonMapper;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("/communityPerson")
public class PersonController {
    @Autowired
    private PersonMapper personMapper;

    @GetMapping
    public List<Person> findPerson(@RequestParam(value = "personName", required = false) String personName,
                                   @RequestParam(value = "personType", required = false) String personType) {
        List<Person> personList;
        if (Objects.equals(personName, "") && Objects.equals(personType, "")) {
            personList = personMapper.findAll();
        } else if (Objects.equals(personName, "")) {
            personList = personMapper.findPersonByType(personType);
        } else if (Objects.equals(personType, "")) {
            personList = personMapper.findPersonByName(personName);
        } else {
            personList = personMapper.findPersonByNameAndType(personName, personType);
        }
        return personList;
    }

    @PostMapping
    public Integer addPerson(@RequestBody Person person) {
        personMapper.addPerson(person);
        return ResultCode.SUCCESS;
    }

    @DeleteMapping
    public Integer delPerson(@RequestBody Person person) {
        personMapper.delPerson(person.getpersonID());
        return ResultCode.SUCCESS;
    }
}
