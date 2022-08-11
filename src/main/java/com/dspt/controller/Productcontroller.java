package com.dspt.controller;

import com.dspt.entity.Buyed;
import com.dspt.entity.Car;
import com.dspt.entity.Product;
import com.dspt.jwt.JWTconfig;
import com.dspt.mapper.Carmapper;
import com.dspt.service.Carservice;
import com.dspt.service.Orderservice;
import com.dspt.service.Productservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shop")
public class Productcontroller {
    @Autowired
    Productservice productservice;
    @Autowired
    Carservice carservice;
    @Autowired
    Orderservice orderservice;
    @GetMapping("/findall")
    public JsonResult findall(){
       return new JsonResult(200,"查询成功",productservice.findAllProduct());
    }
    @GetMapping("findtype")
    public JsonResult findsome(String type){
        return new JsonResult(200,"查询成功",productservice.findTypeProduct(type));
    }
    @GetMapping("finddetil")
    public JsonResult finddetil(String id){
        return new JsonResult(200,"查询成功",productservice.finddetil(id));
    }
    @PostMapping("/addcar")
    public JsonResult addcar(@RequestBody Map map, HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        String id=map.get("id").toString();
        int num=Integer.parseInt(map.get("num").toString());
        Car car=new Car(null,id,username,num);
        carservice.addcar(car);
        return new JsonResult(200,"添加成功",null);
    }
    @PostMapping("/buy")
    public JsonResult buyone(@RequestBody Map map,HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        String id=map.get("id").toString();
        int num=Integer.parseInt(map.get("num").toString());
        Buyed buyed=new Buyed(null,username,id,new Date(),num);
        orderservice.tobuy(buyed);
        return new JsonResult(200,"购买成功",null);
    }
}
