package com.clmts.serviceImpl;

import com.clmts.bean.Manager;
import com.clmts.bean.Order;
import com.clmts.dao.ManagerDao;
import com.clmts.dao.OrderDao;
import com.clmts.dao.Order_ItemDao;
import com.clmts.daoImpl.ManagerDaoImpl;
import com.clmts.daoImpl.OrderDaoImpl;
import com.clmts.daoImpl.Order_ItemDaoImpl;
import com.clmts.service.OrderService;
import com.clmts.util.DBUtil;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private Connection conn = null;
    @Override
    public boolean takeOrder(int manager_id, String name, String phone, String address, int[] product_id, double[] price) {
        System.out.println("OrderServiceImpl.takeOrder...");
        String order_id;
        String time;
        double total = 0;
        OrderDao orderDao=new OrderDaoImpl();
        Order_ItemDao itemDao = new Order_ItemDaoImpl();
        /*
        记录在order表的：
            订单编号(timestamp+id)、时间、经理id、客户姓名、电话、地址
        记录在order_item表的：
            单独售价、商品编号、订单编号
         */
        conn = DBUtil.getConn();
        boolean flag=false;
        try {
            conn.setAutoCommit(false);
            Date date = new Date();
            // 1. 生成订单号
            order_id = String.valueOf(date.getTime()) + manager_id;
            // 2. 获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            time = sdf.format(date);
            // 3. 计算总价
            for (double p : price) {
                total += p;
            }
            // 4. 插入order表
            flag = orderDao.addOrder(order_id, time, manager_id, name, phone, address, total);
            if (!flag) {
                System.out.println("failed to insert into table order");
                System.out.println("----- ---- --");
                return false;
            }
            // 5. 插入order_item表
            for (int i = 0; i < price.length; i++) {
                flag = itemDao.addIteam(product_id[i], price[i], order_id);
                if (!flag) {
                    System.out.println("failed to insert into table order_item");
                    System.out.println("----- ---- --");
                    return false;
                }
            }
            // 业务结束，关闭数据库连接
            conn.commit();
            DBUtil.close();
        }catch (Exception e){
            System.out.println("Exception occurred");
            try {
                System.out.println("rollback!");
                conn.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
            System.out.println("----- ---- --");
        }
        System.out.println("----- ---- --");
        return flag;
    }

    @Override
    public List<Order> searchOrder() {
        System.out.println("OrderServiceImpl.searchOrder...");
        List<Order> orderList = new ArrayList<Order>();
        OrderDao orderDao = new OrderDaoImpl();
        try {
            DBUtil.getConn();
            orderList = orderDao.queryAll();
            DBUtil.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("----- ---- --");
        return orderList;
    }
}
