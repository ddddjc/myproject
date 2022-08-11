package com.dspt.service;

import com.dspt.entity.Car;
import com.dspt.entity.Cardet;
import com.dspt.entity.Cardetail;

import java.util.List;

public interface Carservice {
    List<Cardetail> findcar(String username);
    Cardetail findcardetil(String cid);
    Car findoen(String cid);
    void addcar(Car car);

    void delcar(String cid);

    void delall(String username);
}
