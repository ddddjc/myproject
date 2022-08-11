package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Buyeddet {
    private String bid;
    private String pname;
    private String url;
    private String addr;
    private Double price;
    private int num;

    public Buyeddet(Buyeddetail buyeddetail) {
        this.bid=buyeddetail.getBid();
        this.addr=buyeddetail.getAddr();
        this.url=buyeddetail.getUrl();
        this.price=buyeddetail.getPrice();
        this.num=buyeddetail.getNum();
        this.pname=buyeddetail.getPname();
    }
}
