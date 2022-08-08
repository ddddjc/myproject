package com.dspt.controller;

import com.dspt.entity.User;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class Logincontroller {
    //尝试jwt
    @Autowired
    Userservice userservice;
    @RequestMapping("/per/login")
    public Object aa(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
//        HttpSession session = request.getSession();
        System.out.println(user.toString());
        User findone = userservice.findone(user.getUsername());
        Map<String,Object> map=new HashMap<>();
        if (findone == null) {
            return map.put("message","登录失败");
        } else {
            if (findone.getPassword().equals(user.getPassword())) {
                String token= JWTconfig.getJWTtoken(findone);
                if (user.getUsername().equals("root")) {
                    map.put("token",token);
                    map.put("message","管理员登录成功");
                    return map;
                } else {
                    map.put("token",token);
                    map.put("message","用户登录成功");
                    return map;
                }
            } else {
//                session.setAttribute("usered", "登录失败");
                     map.put("message","登录失败");
                     return map;
            }
        }
    }
}
