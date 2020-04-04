package com.clmts.dao;

import com.clmts.bean.Manager;
import com.clmts.bean.Order;

import java.util.Date;
import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 17:46
 */
public interface OrderDao {
    //添加订单
    boolean addOrder(String order_id, String time, int manager_id,String custom_name,String custom_phone,String custom_address,double total) throws Exception;

    //删除订单
    boolean delOrder(String order_id) throws Exception;

    //更新订单
    boolean updateOrder(String order_id, String time, Manager manager,String custom_name,String custom_phone,String custom_address,double total) throws Exception;

    //根据用户查订单
    List<Order> queryByUser(String order_id) throws Exception;

    //查询单条订单
    Order queryOneOrder(String order_id) throws Exception;




}
