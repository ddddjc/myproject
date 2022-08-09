package com.dspt.controller;

import com.dspt.entity.Cardetail;
import com.dspt.jwt.JWTconfig;
import com.dspt.service.Carservice;
import com.dspt.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("Car")
public class Carcontroller {
    @Autowired
    Carservice carservice;
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

}
