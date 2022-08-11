package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private String id;
    private String label;
    private String type;
    private String url;
    private String url2;
    private String url3;
    private String price;
    private String addr;
    private String phoen;
}
