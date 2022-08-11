package com.dspt.controller;

import com.dspt.entity.*;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Carservice;
import com.dspt.service.Orderservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("car")
public class Carcontroller {
    @Autowired
    Carservice carservice;
    @Autowired
    Orderservice orderservice;
    @GetMapping("/findcar")
    public JsonResult findcar(HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        List<Cardetail> findcar = carservice.findcar(username);
        List<Cardet> cardets=new ArrayList<>();
        for (Cardetail cardetail:findcar){
            cardets.add(new Cardet(cardetail));
        }
        return new JsonResult(200,"查询成功",cardets);
    }
    @GetMapping("findonecar")
    public JsonResult findonecar(String cid){
        System.out.println(cid);
        Cardetail findcardetil = carservice.findcardetil(cid);
        if (findcardetil==null)
            return new JsonResult(400,"查询失败",null);
        return new JsonResult(200,"查询成功",carservice.findcardetil(cid));
    }
    @PostMapping("/del")
    public JsonResult delcar(@RequestBody String cid){
        carservice.delcar(cid);
        return new JsonResult(200,"删除成功",null);
    }
    @GetMapping("/buyone")
    public JsonResult buyoen(@RequestBody String cid, HttpServletRequest request){
        String token=request.getHeader("token");
        String username=JWTconfig.gettokenUsername(token);
        Car car =carservice.findoen(cid);
        if(car==null)
            return new JsonResult(389,"没有此商品",null);
        orderservice.tobuy(car,request);
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
