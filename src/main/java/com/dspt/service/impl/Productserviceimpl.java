package com.dspt.service.impl;

import com.dspt.entity.Pro;
import com.dspt.entity.Product;
import com.dspt.mapper.Productmapper;
import com.dspt.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class Productserviceimpl implements Productservice {
    @Autowired
    Productmapper productmapper;
    @Override
    public List<Pro> findAllProduct() {
//        System.out.println(productmapper.findAllProduct());
        return productmapper.findAllProduct();
    }

    @Override
    public List<Pro> findTypeProduct(String type) {
        return productmapper.findTypeProduct(type);
    }

    @Override
    public Product finddetil(String id){
        return productmapper.findOneProduct(id);
    }
}
