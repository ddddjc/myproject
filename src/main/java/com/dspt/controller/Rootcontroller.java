package com.dspt.controller;

import com.dspt.entity.User;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Rootservice;
import com.dspt.service.Userservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("get")
public class Rootcontroller extends BaseController{
    @Autowired
    Rootservice rootservice;
    @Autowired
    Userservice userservice;
    @RequestMapping("/all")//root操作
    public JsonResult findalluser(HttpServletRequest request){
        String token=request.getHeader("token").toString();
        if(JWTconfig.gettokenUsername(token).equals("root")){
            System.out.println(JWTconfig.gettokenUsername(token));
            List<User> users= rootservice.findall();
            return new JsonResult(OK,"查询成功",users);
        }
        else
            return new JsonResult(FALSE,"未知错误",null);
    }
    @RequestMapping("/alluserdata")
    public JsonResult findsome(@RequestBody String s,HttpServletRequest request){
        int n=Integer.parseInt(s);
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        if(username.equals("root")){
            int a=(n-1)*10;
            int b=10;
            return new JsonResult(OK,"查询成功",rootservice.findsome(a,b));
        }else {
            return new JsonResult(FALSE,"未知错误",null);
        }
    }
    @RequestMapping("/little")
    public JsonResult findlittle(@RequestBody String s,HttpServletRequest request){
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        if(username.equals("root")){
            return new JsonResult(OK,"查询成功",rootservice.findlittle(s));
        }else {
            return new JsonResult(FALSE,"未知错误",null);
        }
    }
    @RequestMapping("/del1")
    public JsonResult del1(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        int n=Integer.parseInt(map.get("n").toString());
        rootservice.del(username);
        int a=(n-1)*10;
        int b=10;
        return new JsonResult(OK,"删除成功",rootservice.findsome(a,b));
    }
    @RequestMapping("/del2")
    public JsonResult del2(@RequestBody Map<String,Object> map){
        String username=map.get("username").toString();
        String s=map.get("s").toString();
        rootservice.del(username);
        return new JsonResult(OK,"删除成功",rootservice.findlittle(s));
    }
    @RequestMapping("/add")
    public JsonResult adduser(@RequestBody User user){
        User findone = userservice.findone(user.getUsername());
        if(findone!=null){
            return new JsonResult(FALSE,"用户名重复，新增失败",null);
        }
        else
        {
            rootservice.add(user);
            return new JsonResult(OK,"新增成功",null);
        }
    }
}
