package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;


@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Buyeddetail {
    private String bid;
    private String id;
    private String label;
    private String type;
    private String url;
    private int price;

    private int all;
    private String addr;
    private String phoen;
    private String username;
    private Date date;
    private int num;

    public Buyeddetail(Product product,Buyed buyed) {
        this.id=product.getId();
        this.addr=product.getAddr();
        this.label=product.getLabel();
        this.phoen=product.getPhoen();
        this.url=product.getUrl();
        this.price=Integer.parseInt(product.getPrice());
        this.type=product.getType();
        this.bid=buyed.getBid();
        this.num=buyed.getNum();
        this.date=buyed.getDate();
        this.all=this.price*this.num;
    }
}
