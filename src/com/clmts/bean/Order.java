package com.clmts.bean;

import java.util.Date;

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

    public Order() {
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
}
