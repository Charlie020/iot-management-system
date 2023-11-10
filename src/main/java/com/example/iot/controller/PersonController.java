package com.example.iot.controller;

import com.example.iot.entity.Person;
import com.example.iot.mapper.PersonMapper;
import com.example.iot.utils.Result;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @PostMapping("/upload")
    public Result addPersonFace(MultipartFile photo) {
        Result result = new Result();
//        String path = "/usr/personFace/" + photo.getOriginalFilename();
        String path = "C:\\Users\\25803\\Desktop\\" + photo.getOriginalFilename();
        File file = new File(path);
        try {
            photo.transferTo(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        result.setSuccess(true);
        result.setCode(20000);
        result.setMessage("成功");
        result.data("url", path);
        return result;
    }

    @DeleteMapping
    public Integer delPerson(@RequestBody Person person) {
        personMapper.delPerson(person.getpersonID());
        return ResultCode.SUCCESS;
    }
}
