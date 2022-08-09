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

@RequestMapping
@RestController
public class Usrmassagecontroller extends BaseController{
    @Autowired
    Userservice userservice;
//    @RequestMapping("/findalluser")//root操作
//    public List<User> findalluser(HttpServletRequest request){
//        String token=request.getHeader("token").toString();
//        if(JWTconfig.getJWTtokenuser(token).getUsername().toString().equals("root")){
//
////        Object username=session.getAttribute("username");
//            System.out.println(JWTconfig.getJWTtokenuser(token).toString());
//            return userservice.findall();
//        }
//        else
//            return null;
//    }
    @PostMapping("/find/info")
    public JsonResult<User> findmyself(HttpServletRequest request){
//        Object username=session.getAttribute("username");
//        System.out.println(userservice.findone(username.toString()));
//        System.out.println(userservice.findone(username.toString()));
        String token=request.getHeader("token");
        if(JWTconfig.gettokenUsername((token))==null)
            return new JsonResult<User>(FALSE,"未知错误",null);
        User user= userservice.findone(JWTconfig.gettokenUsername(token));
        return new JsonResult<User>(OK,"查询成功",user);
    }
    @PostMapping("/per/edit")
    public JsonResult<User> changemyself(@RequestBody User user, HttpServletRequest request){
        userservice.update(user);
        System.out.println(userservice.findone(user));
        return new JsonResult<User>(OK,"修改成功",userservice.findone(user));
    }
//    @RequestMapping("/photo")
//    public void photo(@RequestBody String url,HttpServletRequest request)
//    {
//        String username=JWTconfig.gettokenUsername(request.getHeader("token"));
//        System.out.println(username);
//         userservice.updatetx(url,username);
//    }
//    @RequestMapping("/test1")
//    public User aann(HttpServletRequest request){
//        String token=request.getHeader("token");
//        String username=JWTconfig.gettokenUsername(token);
//        String name= JWTconfig.gettokenName(token);
//        System.out.println(token);
//        System.out.println(username);
//        System.out.println(name);
//        return userservice.findone(username);
//    }
}
