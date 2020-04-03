package com.clmts.serviceImpl;

import com.clmts.bean.Manager;
import com.clmts.dao.ManagerDao;
import com.clmts.dao.OrderDao;
import com.clmts.daoImpl.ManagerDaoImpl;
import com.clmts.daoImpl.OrderDaoImpl;
import com.clmts.service.OrderService;
import com.clmts.util.DBUtil;

import java.sql.Connection;
import java.util.Date;

public class OrderServiceImpl implements OrderService {
    private Connection conn = null;
    @Override
    public boolean takeOrder(String name, String phone, String address, int[] product_id, double[] price) {
        String order_id;
        String time;
        String total;
        OrderDao orderDao=new OrderDaoImpl();
        ManagerDao managerDao=new ManagerDaoImpl();
        conn= DBUtil.getConn();
        boolean flag=false;
        try{


        }catch (Exception e){
            e.printStackTrace();}



        return false;
    }
}
