package com.dspt.controller;

import com.dspt.entity.User;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Rootservice;
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
            int a=(n-1)*5;
            int b=n*5;
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
            return rootservice.findlittle("o");
        }else {
            return null;
        }
    }
    @RequestMapping("/del1")
    public List<User> del1(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        int n=Integer.parseInt(map.get("n").toString());
        rootservice.del(username);
        return rootservice.findsome((n-1)*5,n*5);
    }
    @RequestMapping("/del2")
    public List<User> del2(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String s=map.get("s").toString();
        rootservice.del(username);
        return rootservice.findlittle(s);
    }
}
