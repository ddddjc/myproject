package com.dspt.controller;

import com.dspt.entity.Car;
import com.dspt.entity.Product;
import com.dspt.jwt.JWTconfig;
import com.dspt.mapper.Carmapper;
import com.dspt.service.Carservice;
import com.dspt.service.Productservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class Productcontroller {
    @Autowired
    Productservice productservice;
    @Autowired
    Carservice carservice;
    @PostMapping("/findall")
    public JsonResult findall(){
       return new JsonResult(200,"查询成功",productservice.findAllProduct());
    }
    @PostMapping("findtype")
    public JsonResult findsome(@RequestBody String type){
        return new JsonResult(200,"查询成功",productservice.findTypeProduct(type));
    }
    @PostMapping("/addcar")
    public JsonResult addcar(@RequestBody String id, HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        Car car=new Car(null,id,username,1);
        carservice.addcar(car);
        return new JsonResult(200,"添加成功",null);
    }
}
