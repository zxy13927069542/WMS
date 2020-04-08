package cn.ying.domain;

import java.io.Serializable;

/**
 * 货物实体类
 */
public class Goods implements Serializable {
    //货物唯一标识
    private Integer id;

    //货物名称
    private String name;

    //货物类型
    private String type;

    //货物大小
    private String size;

    //货物产地
    private String origin;

    //货物价格
    private float price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setSize(String size){
        this.size = size;
    }

    public String getSize(){
        return size;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }
}
