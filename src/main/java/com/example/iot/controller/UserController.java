package com.example.iot.controller;

import com.example.iot.entity.User;
import com.example.iot.mapper.UserMapper;
import com.example.iot.utils.JwtUtils;
import com.example.iot.utils.Result;
import com.example.iot.utils.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public Result Verify(@RequestBody User user) {
        Result result = new Result();
        User retUser = userMapper.findUser(user);
        if (retUser == null) {
            result.setSuccess(false);
            result.setCode(ResultCode.ERROR);
            result.setMessage("Fail to find user.");
            return result;
        } else {
            result.setSuccess(true);
            result.setCode(ResultCode.SUCCESS);
            result.setMessage("Success!");
            String token = JwtUtils.generateToken(user);
            result.data("token", token);
            return result;
        }
    }

    @GetMapping("/info")
    public Result info(String token) {
        Result result = new Result();
        String unpd = JwtUtils.getClaimsByToken(token).getSubject();
        // 查找字符'&'的位置
        char targetChar = '&';
        int index = unpd.indexOf(targetChar);
        // 分割字符串
        String username = unpd.substring(0, index);
        String password = unpd.substring(index + 1);
        String url = "https://pic1.zhimg.com/80/v2-b77eb2cc5d21d3714aefd3a29042f32d_qhd.jpg";
        return result.ok().data("username", username).data("password", password)
                .data("role", "admin").data("introduction", "I am a super administrator.")
                .data("avatar", url).data("name", "Super Admin");
    }

    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }
}
