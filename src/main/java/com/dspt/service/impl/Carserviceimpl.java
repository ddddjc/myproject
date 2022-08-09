package com.dspt.service.impl;

import com.dspt.entity.Car;
import com.dspt.entity.Cardetail;
import com.dspt.entity.Product;
import com.dspt.mapper.Carmapper;
import com.dspt.mapper.Productmapper;
import com.dspt.service.Carservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Carserviceimpl implements Carservice {
    @Autowired
    Carmapper carmapper;
    @Autowired
    Productmapper productmapper;
    @Override
    public List<Cardetail> findcar(String username) {
        List<Car> cars=carmapper.findcar(username);
        if (cars==null){
            return null;
        }
        List<Cardetail> cardetails =new ArrayList<>();
        for(Car car:cars) {
            Product product = productmapper.findOneProduct(car.getId());
            Cardetail cardetail = new Cardetail(product, car);
            cardetails.add(cardetail);
        }
        return cardetails;
    }

    @Override
    public void delall(String username) {
        carmapper.delall(username);
    }

    @Override
    public Car findoen(String cid) {
        return carmapper.findoen(cid);
    }

    @Override
    public void addcar(Car car) {
         carmapper.addcar(car);
    }

    @Override
    public void delcar(String cid) {
          carmapper.delcar(cid);
    }
}
