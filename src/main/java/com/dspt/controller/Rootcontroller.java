package com.dspt.controller;

import com.dspt.entity.User;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Rootservice;
import com.dspt.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("get")
public class Rootcontroller {
    @Autowired
    Rootservice rootservice;
    @Autowired
    Userservice userservice;
    @RequestMapping("/all")//root操作
    public List<User> findalluser(HttpServletRequest request){
        String token=request.getHeader("token").toString();
        if(JWTconfig.gettokenUsername(token).equals("root")){
            System.out.println(JWTconfig.gettokenUsername(token));
            return rootservice.findall();
        }
        else
            return null;
    }
    @RequestMapping("/alluserdata")
    public List<User> findsome(@RequestBody String s,HttpServletRequest request){
        int n=Integer.parseInt(s);
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        if(username.equals("root")){
            int a=(n-1)*10;
            int b=10;
            return rootservice.findsome(a,b);
        }else {
            return null;
        }
    }
    @RequestMapping("/little")
    public List<User> findlittle(@RequestBody String s,HttpServletRequest request){
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        if(username.equals("root")){
            return rootservice.findlittle(s);
        }else {
            return null;
        }
    }
    @RequestMapping("/del1")
    public List<User> del1(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        int n=Integer.parseInt(map.get("n").toString());
        rootservice.del(username);
        int a=(n-1)*10;
        int b=10;
        return rootservice.findsome(a,b);
    }
    @RequestMapping("/del2")
    public List<User> del2(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String s=map.get("s").toString();
        rootservice.del(username);
        return rootservice.findlittle(s);
    }
    @RequestMapping("/add")
    public String adduser(@RequestBody User user){
        User findone = userservice.findone(user.getUsername());
        if(findone!=null){
            return "用户名重复，新增失败";
        }
        else
        {
            userservice.add(user);
            return "新增成功";
        }
    }
}
