package com.dspt.controller;

import com.dspt.entity.Buyed;
import com.dspt.entity.Buyeddetail;
import com.dspt.entity.Car;
import com.dspt.entity.Cardetail;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Carservice;
import com.dspt.service.Orderservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("Car")
public class Carcontroller {
    @Autowired
    Carservice carservice;
    @Autowired
    Orderservice orderservice;
    @PostMapping("/findcar")
    public JsonResult findcar(HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        List<Cardetail> findcar = carservice.findcar(username);
        return new JsonResult(200,"查询成功",findcar);
    }
    @PostMapping("/del")
    public JsonResult delcar(@RequestBody String cid){
        carservice.delcar(cid);
        return new JsonResult(200,"删除成功",null);
    }
    @PostMapping("/buyone")
    public JsonResult buyoen(@RequestBody String cid,HttpServletRequest request){
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        Car car =carservice.findoen(cid);
        if(car==null)
            return new JsonResult(389,"没有此商品",null);
        orderservice.tobuy(car.getId(),request);
        carservice.delcar(cid);
        return new JsonResult(200,"购买成功",null);
    }
    @PostMapping("/buyall")
     public JsonResult buyall(HttpServletRequest request){
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        List<Cardetail> cardetails=carservice.findcar(username);
        for(Cardetail cardetail:cardetails){
            Buyed buyed=new Buyed(null,username,cardetail.getId(),new Date(),cardetail.getNum());
            orderservice.tobuy(buyed);
        }
        carservice.delall(username);
        return new JsonResult(200,"购买成功",null);
    }
    @PostMapping("delall")
    public JsonResult delall(HttpServletRequest request){
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        carservice.delall(username);
        return new JsonResult(200,"删除成功",null);
    }
}
