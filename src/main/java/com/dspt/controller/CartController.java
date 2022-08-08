package com.dspt.controller;

import com.dspt.jwt.JWTconfig;
import com.dspt.service.ICartService;
import com.dspt.util.JsonResult;
import com.dspt.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("carts")
public class CartController extends BaseController {

    @Autowired
    private ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpServletRequest request){
        System.out.println("pid= " + pid);
        System.out.println("amount= "+ amount);
        //获取username和name
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        String name=JWTconfig.gettokenName(token);
        //业务层添加到购物车
        cartService.addToCart(username,pid,amount,name);
        //成功返回
        return new JsonResult<Void>(OK);
    }



    @GetMapping({"", "/"})
    public JsonResult<List<CartVO>> getVOByUid(HttpServletRequest request) {
        // 获取username
        String token=request.getHeader("token");
        String username =  JWTconfig.gettokenUsername(token);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByUid(username);
        // 返回成功与数据
        return new JsonResult<List<CartVO>>(OK, data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid") Integer cid, HttpServletRequest request) {
        // 获取username,name
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        String name=JWTconfig.gettokenName(token);
        // 调用业务对象执行增加数量
        Integer data = cartService.addNum(cid, username, name);
        // 返回成功
        return new JsonResult<Integer>(OK, data);
    }

    @GetMapping("list")
    public JsonResult<List<CartVO>> getVOByCids(Integer[] cids, HttpServletRequest request) {
        // 获取username
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        // 调用业务对象执行查询数据
        List<CartVO> data = cartService.getVOByCids(username, cids);
        // 返回成功与数据
        return new JsonResult<>(OK, data);
    }
}
