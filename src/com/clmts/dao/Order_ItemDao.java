package com.clmts.dao;

import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 17:47
 */
public interface Order_ItemDao {
    //添加订单
    boolean addIteam(int product_id,double price,String order_id) throws Exception;

    //删除订单
    boolean delIteam(int item_id,int product_id,double price,String order_id) throws Exception;

    // 查询订单细则
    List queryItem(String order_id) throws Exception;

}
