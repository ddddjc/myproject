package com.dspt.mapper;

import com.dspt.entity.Pro;
import com.dspt.entity.Product;

import java.util.List;

public interface Productmapper {
    List<Pro> findAllProduct();

    List<Pro> findTypeProduct(String type);

    Product findOneProduct(String id);
}
