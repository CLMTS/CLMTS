package com.clmts.bean;

import java.util.Date;
import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 18:17
 */
public class Order {
    private String order_id;
    private Date time;
    private Manager manager;
    private String custom_name;
    private String custom_phone;
    private String custom_address;
    private double total;
    private List<Order_Item> orderItemList;


    public Order() {
    }

    public Order(String order_id, Date time, Manager manager, String custom_name, String custom_phone, String custom_address, double total) {
        this.order_id = order_id;
        this.time = time;
        this.manager = manager;
        this.custom_name = custom_name;
        this.custom_phone = custom_phone;
        this.custom_address = custom_address;
        this.total = total;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getCustom_name() {
        return custom_name;
    }

    public void setCustom_name(String custom_name) {
        this.custom_name = custom_name;
    }

    public String getCustom_phone() {
        return custom_phone;
    }

    public void setCustom_phone(String custom_phone) {
        this.custom_phone = custom_phone;
    }

    public String getCustom_address() {
        return custom_address;
    }

    public void setCustom_address(String custom_address) {
        this.custom_address = custom_address;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Order_Item> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<Order_Item> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
