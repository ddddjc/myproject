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
    private String id;
    private String label;
    private String type;
    private String url;
    private String price;
    private String addr;
    private String phoen;
//    private String cid;
//    private String username;
    private int num;

    public Cardetail(Product product, Car car) {
        this.id=product.getId();
        this.addr=product.getAddr();
        this.label=product.getLabel();
        this.phoen=product.getPhoen();
        this.url=product.getUrl();
        this.price=product.getPrice();
        this.type=product.getType();
//        this.cid=car.getCid();
//        this.username=car.getUsername();
        this.num=car.getNum();
    }
}
