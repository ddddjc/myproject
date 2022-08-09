package com.dspt.service;

import com.dspt.entity.Car;
import com.dspt.entity.Cardetail;

import java.util.List;

public interface Carservice {
    List<Cardetail> findcar(String username);

    void addcar(Car car);

    void delcar(String cid);
}
