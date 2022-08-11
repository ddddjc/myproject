package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Cardet {
    private String cid;
    private String pname;
    private String url;
    private Double price;
    private int num;
    private Double all;

    public Cardet(Cardetail cardetail) {
        this.cid=cardetail.getCid();
        this.pname=cardetail.getPname();
        this.url=cardetail.getUrl();
        this.price=cardetail.getPrice();
        this.num=cardetail.getNum();
        this.all=cardetail.getAll();
    }
}
