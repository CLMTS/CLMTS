package com.clmts.service;

public interface OrderService {
    boolean takeOrder(String name, String phone, String address, int[] product_id, double[] price);
}
