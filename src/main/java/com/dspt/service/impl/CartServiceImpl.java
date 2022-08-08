package com.dspt.service.impl;

import com.dspt.entity.Cart;
import com.dspt.entity.Product;
import com.dspt.mapper.CartMapper;
import com.dspt.service.ICartService;
import com.dspt.service.IProductService;
import com.dspt.service.ex.AccessDeniedException;
import com.dspt.service.ex.CartNotFoundException;
import com.dspt.service.ex.InsertException;
import com.dspt.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private IProductService productService;

    @Override
    public void addToCart(String username, Integer pid, Integer amount, String name) {
        Cart result = cartMapper.findByUidAndPid(username, pid);
        Date now = new Date();
        if(result==null){
            Cart cart= new Cart();
            cart.setUsername(username);
            cart.setPid(pid);
            cart.setNum(amount);
            // 调用productService.findById(pid)查询商品数据，得到商品价格
            Product product = productService.findById(pid);
            // 封装数据：price
            cart.setPrice(product.getPrice());
            // 封装数据：4个日志
            cart.setCreatedUser(name);
            cart.setCreatedTime(now);
            cart.setModifiedUser(name);
            cart.setModifiedTime(now);
            // 调用insert(cart)执行将数据插入到数据表中
            Integer rows = cartMapper.insert(cart);
            if(rows!=1){
                throw new InsertException("添加商品时出现错误，请联系管理员");
            }
        }else{
            Integer cid = result.getCid();
            Integer num=result.getNum()+amount;
            Integer rows = cartMapper.updateNumByCid(cid,num,name,now);
            if(rows!=1){
                throw new InsertException("修改商品数量时出现错误，请联系管理员");
            }
        }

    }

    @Override
    public List<CartVO> getVOByUid(String username) {
        return cartMapper.findVOByUid(username);
    }

    @Override
    public Integer addNum(Integer cid, String username, String name) {
        Cart result = cartMapper.findByCid(cid);
        if(result==null){
            throw new CartNotFoundException("商品不存在于购物车");
        }
        if(!result.getUsername().equals(username)){
            throw new AccessDeniedException("错误的访问");
        }

        Date now = new Date();
        Integer num = result.getNum()+1;
        Integer rows=cartMapper.updateNumByCid(cid,num,name,now);
        if(rows!=1){
            throw new InsertException("修改商品时出现位置错误，请联系管理员");
        }
        return num;
    }

    @Override
    public List<CartVO> getVOByCids(String username, Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCids(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()) {
            CartVO cart = it.next();
            if (!cart.getUsername().equals(username)) {
                it.remove();
            }
        }
        return list;
    }
}

