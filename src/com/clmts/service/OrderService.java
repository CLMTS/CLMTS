package com.clmts.service;

public interface OrderService {
    boolean takeOrder(int manager_id, String name, String phone, String address, int[] product_id, double[] price);
}
