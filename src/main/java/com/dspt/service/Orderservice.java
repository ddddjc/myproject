package com.dspt.service;

import com.dspt.entity.Buyeddetail;
import com.dspt.entity.Cardetail;
import com.dspt.mapper.Carmapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Orderservice {
//    List<Cardetail> nobuy(String username);
    List<Buyeddetail> buyed(String username);

    void tobuy(String id, HttpServletRequest request);
}
