package com.dspt.controller;


import com.dspt.entity.User;
import com.dspt.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping
@RestController
public class Registercontroller {
    @Autowired
    Userservice userservice;
    @RequestMapping("/register/getmenu")
    public String register(@RequestBody User user, HttpServletRequest request) {
        System.out.println(user.toString());
        User findone = userservice.findone(user.getUsername());
        if(findone!=null){
            return "用户名重复，注册失败";
        }
        else
        {
            userservice.add(user);
            return "注册成功";
        }
    }
}
