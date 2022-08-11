package com.dspt.controller;

import com.dspt.entity.Buyed;
import com.dspt.entity.Car;
import com.dspt.entity.Cardet;
import com.dspt.entity.Cardetail;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Carservice;
import com.dspt.service.Orderservice;
import com.dspt.service.Productservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class Ordercontroller {
    @Autowired
    Productservice productservice;
    @Autowired
    Orderservice orderservice;
    @Autowired
    Carservice carservice;
    @PostMapping("/buyproduct")
    public JsonResult buyproduct(@RequestBody String cid, HttpServletRequest request){
        Car findoen = carservice.findoen(cid);
        orderservice.tobuy(new Buyed(null,findoen.getUsername(),findoen.getId(),new Date(),findoen.getNum()));
        carservice.delcar(cid);
        return new JsonResult<>(200,"购买成功",null);
    }
    @GetMapping("/nobuy")
    public JsonResult nobuy(HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        List<Cardetail> findcar = carservice.findcar(username);
        List<Cardet> cardets=new ArrayList<>();
        for (Cardetail cardetail:findcar){
            cardets.add(new Cardet(cardetail));
        }
        return new JsonResult(200,"查询成功",cardets);
//        return new JsonResult(200,"查询成功",carservice.findcar(username));
    }
    @GetMapping("/bought")
    public JsonResult bought(HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        return new JsonResult(200,"查询成功",orderservice.buyed(username));
    }
    @GetMapping("/findbought")
    public JsonResult findbought(String bid){
          return new JsonResult(200,"查询成功",orderservice.findone(bid));
    }
}
