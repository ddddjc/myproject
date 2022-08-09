package com.dspt.controller;

import com.dspt.jwt.JWTconfig;
import com.dspt.service.Carservice;
import com.dspt.service.Orderservice;
import com.dspt.service.Productservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    public JsonResult buyproduct(@RequestBody String id, HttpServletRequest request){
        orderservice.tobuy(id,request);
        return new JsonResult<>(200,"购买成功",null);
    }
    @GetMapping("/nobuy")
    public JsonResult nobuy(HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        return new JsonResult(200,"查询成功",carservice.findcar(username));
    }
    @GetMapping("/bought")
    public JsonResult bought(HttpServletRequest request){
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        return new JsonResult(200,"查询成功",orderservice.buyed(username));
    }
}
