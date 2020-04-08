package cn.ying.domain;

import java.io.Serializable;

/**
 * 库存表实体类
 */
public class Stock implements Serializable {
    //货物id
    private Integer goodsId;

    //货物总数目
    private Integer amount;

    //货物存储地
    private String address;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "goodsId=" + goodsId +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                '}';
    }
}
