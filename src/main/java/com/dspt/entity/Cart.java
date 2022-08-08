package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/** 购物车数据的实体类 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart extends BaseEntity implements Serializable {
    private Integer cid;
    private String username;
    private Integer pid;
    private Long price;
    private Integer num;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart)) return false;

        Cart cart = (Cart) o;

        if (getCid() != null ? !getCid().equals(cart.getCid()) : cart.getCid() != null) return false;
        if (getUsername() != null ? !getUsername().equals(cart.getUsername()) : cart.getUsername() != null) return false;
        if (getPid() != null ? !getPid().equals(cart.getPid()) : cart.getPid() != null) return false;
        if (getPrice() != null ? !getPrice().equals(cart.getPrice()) : cart.getPrice() != null) return false;
        return getNum() != null ? getNum().equals(cart.getNum()) : cart.getNum() == null;
    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", username=" + username +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                "} " + super.toString();
    }
}
