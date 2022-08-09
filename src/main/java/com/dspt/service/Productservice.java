package com.dspt.service;

import com.dspt.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


public interface Productservice {
    List<Product> findAllProduct();

    List<Product> findTypeProduct(String type);

}
