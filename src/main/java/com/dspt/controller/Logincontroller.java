package com.dspt.controller;

import com.dspt.entity.User;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Userservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping
public class Logincontroller extends BaseController{
    //尝试jwt
    @Autowired
    Userservice userservice;
    @PostMapping("/per/login")
    public JsonResult<String> aa(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
        System.out.println(user.toString());
        User findone = userservice.findone(user.getUsername());
        if (findone == null) {
            String s="用户已存在";
            return new JsonResult<String>(NOONE,s,null);
        } else {
            if (findone.getPassword().equals(user.getPassword())) {
                String token= JWTconfig.getJWTtoken(findone);
                if (user.getUsername().equals("root")) {
                    return new JsonResult<String>(OK,"管理员登录成功",token);
                } else {
                    return new JsonResult<String>(OK,"用户登录成功",token);
                }
            } else {
//                session.setAttribute("usered", "登录失败");
                     return new JsonResult<>(PAFALSE,"密码错误",null);
            }
        }
    }
}
