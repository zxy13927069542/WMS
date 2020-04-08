package cn.ying.domain;

/**
 * 数据库视图goods_stock的对应实体类
 */
public class Goods_Stock {
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

    //货物总数目
    private Integer amount;

    //货物存储地
    private String address;

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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        return "Goods_Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", size='" + size + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", address='" + address + '\'' +
                '}';
    }

}
