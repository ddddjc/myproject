package com.dspt.service.impl;

import com.dspt.entity.*;
import com.dspt.jwt.JWTconfig;
import com.dspt.mapper.Buyedmapper;
import com.dspt.mapper.Carmapper;
import com.dspt.mapper.Productmapper;
import com.dspt.service.Orderservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class Oederserviceimpl implements Orderservice {
    @Autowired
    Productmapper productmapper;
    @Autowired
    Carmapper carmapper;
    @Autowired
    Buyedmapper buyedmapper;

//    @Override
//    public List<Cardetail> nobuy(String username) {
//        List<Car> cars=carmapper.findcar(username);
//        if (cars==null)
//            return null;
//        List<Cardetail> cardetails=new ArrayList<>();
//        for (Car car:cars){
//            Product product = productmapper.findOneProduct(car.getId());
//            Cardetail cardetail = new Cardetail(product, car);
//            cardetails.add(cardetail);
//        }
//        return cardetails;
//    }

    @Override
    public List<Buyeddetail> buyed(String username) {
        List<Buyeddetail> buyeddetails=new ArrayList<>();
        List<Buyed> buyeds=buyedmapper.findAllBuyed(username);
        if (buyeds==null)
            return null;
        for(Buyed buyed:buyeds){
            Product oneProduct = productmapper.findOneProduct(buyed.getId());
            Buyeddetail buyeddetail=new Buyeddetail(oneProduct,buyed);
            buyeddetails.add(buyeddetail);
        }
        return buyeddetails;
    }

    @Override
    public void tobuy(String id, HttpServletRequest request) {
        String token=request.getHeader("token");
        String username= JWTconfig.gettokenUsername(token);
        Buyed buyed=new Buyed(null,username,id,new Date(),1);
        buyedmapper.addbuyed(buyed);
    }

    @Override
    public void tobuy(Buyed buyed) {
        buyedmapper.addbuyed(buyed);
    }
}