package com.clmts.bean;

/**
 * @author suhao
 * @create_date 2020-04-01 23:02
 */
public class Order_Item {
    private int item_id;
    private int product_id ;
    private double price;
    private String order_id;

    public Order_Item() {
    }

    public Order_Item(int item_id, int product_id, double price,String order_id) {
        this.item_id = item_id;
        this.product_id = product_id;
        this.price = price;
        this.order_id= order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
