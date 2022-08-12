package com.dspt.controller;

import com.dspt.config.AesEncryptUtils;
import com.dspt.entity.User;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Userservice;
import com.dspt.util.JsonResult;
import org.apache.catalina.Service;
import org.apache.commons.net.nntp.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RequestMapping
@RestController
public class Usrmassagecontroller extends BaseController{
    @Autowired
    Userservice userservice;

    @GetMapping("/find/info")
    public JsonResult<User> findmyself(HttpServletRequest request) throws Exception {

        String token=request.getHeader("token");
        if(JWTconfig.gettokenUsername((token))==null)
            return new JsonResult<User>(FALSE,"未知错误",null);
        User user= userservice.findone(JWTconfig.gettokenUsername(token));
        return new JsonResult<User>(OK,"查询成功",AesEncryptUtils.useredcrpt(user));
    }
    @PostMapping("/per/edit")
    public JsonResult<User> changemyself(@RequestBody User user, HttpServletRequest request) throws Exception {
        userservice.update(user);
        String token=request.getHeader("token");
        User user1= userservice.findone(JWTconfig.gettokenUsername(token));
        return new JsonResult<User>(OK,"修改成功",AesEncryptUtils.useredcrpt(user1));
    }

@PostMapping("/changephoto")
    public JsonResult changphoto(@RequestBody String Base64data,HttpServletRequest request) throws Exception {
    /**
     * 1.获取到后面到数据
     */
    String[] d=Base64data.split("base64,");
    String data=new String();
    String datatype=new String();
    if(d!=null&&d.length==2){
        datatype=d[0];
         data =d[1];
    }else return new JsonResult(460,"文件格式错误",null);
    String token=request.getHeader("token");
    String username=JWTconfig.gettokenUsername(token);
//    System.out.println(data);
    byte[] bs= Base64Utils.decodeFromString(data);
    for(int i=0;i<bs.length;++i) {
        if(bs[i]<0) {
            //调整异常数据
            bs[i]+=256;
        }}
    String rpath= ResourceUtils.getURL("classpath").getPath()+"/static/userphoto/"+username+".jpg";
//    String path="E:\\pro\\userphotos\\"+username+".jpg";
    String path="/home/feidian/djc/userphotos/"+username+".jpg";
    System.out.println(path);
        //使用apache提供的工具类操作流
        OutputStream out = new FileOutputStream(path);
        out.write(bs);
        out.flush();
        out.close();
    return new JsonResult(460,"上传成功",null);
}

}
