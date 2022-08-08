package com.dspt.service;

import com.dspt.vo.CartVO;

import java.util.List;


public interface ICartService {

    //添加到购物车
    void addToCart(String username,Integer pid,Integer amount,String name);

    //查询用户购物车数据
    List<CartVO> getVOByUid(String username);

    //数量加一
    Integer addNum(Integer cid, String username, String name);

    //根据多个id查询购物车测数据
    List<CartVO> getVOByCids(String username, Integer[] cids);
}
