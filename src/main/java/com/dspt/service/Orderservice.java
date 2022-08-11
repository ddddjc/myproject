package com.dspt.service;

import com.dspt.controller.Carcontroller;
import com.dspt.entity.*;
import com.dspt.mapper.Carmapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Orderservice {
//    List<Cardetail> nobuy(String username);
    List<Buyeddet> buyed(String username);

    void tobuy(Car car, HttpServletRequest request);
    void tobuy(Buyed buyed);

    Buyeddetail findone(String bid);
}
