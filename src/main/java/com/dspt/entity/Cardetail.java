package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cardetail {
    private String cid;
    private String id;
    private String pname;
    private String label;
    private String type;
    private String url;
    private Double price;
    private int num;
    private Double all;
    private String addr;
    private String phoen;
//    private String username;

    public Cardetail(Product product, Car car) {
        this.id=product.getId();
        this.addr=product.getAddr();
        this.label=product.getLabel();
        this.phoen=product.getPhoen();
        this.url=product.getUrl();
        this.pname=product.getPname();
        this.price=product.getPrice();
        this.type=product.getType();
        this.cid=car.getCid();
//        this.username=car.getUsername();
        this.num=car.getNum();
        this.all=this.price*this.num;
    }
}
