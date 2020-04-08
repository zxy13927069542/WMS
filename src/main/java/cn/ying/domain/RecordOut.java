package cn.ying.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 出库记录表实体类
 */
public class RecordOut implements Serializable {
    //出库记录唯一标识
    private Integer id;

    //货物id
    private Integer goodsId;

    //出库数目
    private Integer amount;

    //出库时间
    private Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "RecordOut{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}
