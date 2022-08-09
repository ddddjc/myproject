package com.dspt.controller;


import com.dspt.entity.User;
import com.dspt.service.Userservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequestMapping
@RestController
public class Registercontroller extends BaseController{
    @Autowired
    Userservice userservice;
    @PostMapping("/register/getmenu")
    public JsonResult register(@RequestBody User user, HttpServletRequest request) {
        System.out.println(user.toString());
        User findone = userservice.findone(user.getUsername());
        if(findone!=null){
            return new JsonResult(HAD,"用户名重复，注册失败",null);
        }
        else
        {
            userservice.add(user);
            return new JsonResult(OK,"注册成功",null);
        }
    }
}
