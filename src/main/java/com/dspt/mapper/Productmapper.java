package com.dspt.mapper;

import com.dspt.entity.Product;

import java.util.List;

public interface Productmapper {
    List<Product> findAllProduct();

    List<Product> findTypeProduct(String type);

    Product findOneProduct(String id);
}
