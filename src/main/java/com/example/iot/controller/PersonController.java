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
    public Result addPerson(@RequestBody Person person) {
        Result result = new Result();
        if (person.getpersonID().length() != 18) {
            result.setCode(ResultCode.ERROR);
            result.setMessage("身份证号位数错误！");
        } else if (!personMapper.findPersonByID(person.getpersonID()).isEmpty()) {
            result.setCode(ResultCode.ERROR);
            result.setMessage("身份证号已存在！");
        } else if (!personMapper.findPersonByPhone(person.getpersonPhone()).isEmpty()) {
            result.setCode(ResultCode.ERROR);
            result.setMessage("电话号码已存在！");
        } else {
            personMapper.addPerson(person);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("插入成功！");
        }
        return result;
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
        result.setCode(ResultCode.SUCCESS);
        result.setMessage("成功");
        result.data("url", path);
        return result;
    }

    @DeleteMapping
    public Result delPerson(@RequestBody Person person) {
        Result result = new Result();
        if (personMapper.findPersonByID(person.getpersonID()).isEmpty()) {
            result.setCode(ResultCode.ERROR);
            result.setMessage("系统中未找到该人，无法删除！");
        } else {
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("删除成功！");
            personMapper.delPerson(person.getpersonID());
        }
        return result;
    }
}
