package com.clmts.service;

import com.clmts.bean.Order;

import java.util.List;

public interface OrderService {
    boolean takeOrder(int manager_id, String name, String phone, String address, int[] product_id, double[] price);

    List<Order> searchOrder();
}
