package com.dspt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/** 购物车数据的Value Object类 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CartVO implements Serializable {
    private Integer cid;
    private String username;
    private Integer pid;
    private Long price;
    private Integer num;
    private String title;
    private Long realPrice;
    private String image;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CartVO)) return false;

        CartVO cartVO = (CartVO) o;

        if (getCid() != null ? !getCid().equals(cartVO.getCid()) : cartVO.getCid() != null) return false;
        if (getUsername() != null ? !getUsername().equals(cartVO.getUsername()) : cartVO.getUsername() != null) return false;
        if (getPid() != null ? !getPid().equals(cartVO.getPid()) : cartVO.getPid() != null) return false;
        if (getPrice() != null ? !getPrice().equals(cartVO.getPrice()) : cartVO.getPrice() != null) return false;
        if (getNum() != null ? !getNum().equals(cartVO.getNum()) : cartVO.getNum() != null) return false;
        if (getTitle() != null ? !getTitle().equals(cartVO.getTitle()) : cartVO.getTitle() != null) return false;
        if (getRealPrice() != null ? !getRealPrice().equals(cartVO.getRealPrice()) : cartVO.getRealPrice() != null)
            return false;
        return getImage() != null ? getImage().equals(cartVO.getImage()) : cartVO.getImage() == null;
    }

    @Override
    public int hashCode() {
        int result = getCid() != null ? getCid().hashCode() : 0;
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPid() != null ? getPid().hashCode() : 0);
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + (getNum() != null ? getNum().hashCode() : 0);
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getRealPrice() != null ? getRealPrice().hashCode() : 0);
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", uid=" + username +
                ", pid=" + pid +
                ", price=" + price +
                ", num=" + num +
                ", title='" + title + '\'' +
                ", realPrice=" + realPrice +
                ", image='" + image + '\'' +
                '}';
    }
}
