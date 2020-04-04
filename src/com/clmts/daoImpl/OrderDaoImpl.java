package com.clmts.daoImpl;

import com.clmts.bean.Manager;
import com.clmts.bean.Order;
import com.clmts.dao.ManagerDao;
import com.clmts.dao.OrderDao;
import com.clmts.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 18:45
 */
public class OrderDaoImpl implements OrderDao {
    ResultSet rs=null;
    @Override
    public boolean addOrder(String order_id, String time, int manager_id, String custom_name, String custom_phone, String custom_address,double total) throws SQLException {
        int row=0;
        String sql="insert into `order`(order_id,time,manager,custom_name,custom_phone,custom_address,total) values (?,?,?,?,?,?,?)";
        row= DBUtil.executeUpdate(sql,order_id,time,manager_id,custom_name,custom_phone,custom_address,total);
        return (row!=0)?true:false;
    }

    @Override
    public boolean delOrder(String order_id) throws SQLException {
        int row=0;
        String sql="delete from `order` where order_id=?";
        row=DBUtil.executeUpdate(sql,order_id);
        return (row!=0)?true:false;
    }

    @Override
    public boolean updateOrder(String order_id, String time, Manager manager, String custom_name, String custom_phone, String custom_address,double total) throws SQLException {
        int row=0;
        String sql="update `order` set time=?,manager=?,custom_name=?,custom_phone=?,custom_address=?,total=? where order_id=?";
        row=DBUtil.executeUpdate(sql,time,manager,custom_name,custom_phone,custom_address,total);
        return (row!=0)?true:false;
    }

    @Override
    public List<Order> queryByUser(String order_id) throws SQLException {
        List<Order> list =new ArrayList<>();
        String sql="select * from `order` where order_id=?";
        rs=DBUtil.executeQuery(sql);
        while(rs.next()){
            Order order=new Order();
            order.setOrder_id(rs.getString("order_id"));
            order.setTime(rs.getTimestamp("time"));
            order.setManager((Manager)rs.getObject("manager"));
            order.setCustom_name(rs.getString("custom_name"));
            order.setCustom_phone(rs.getString("custom_phone"));
            order.setCustom_address(rs.getString("custom_address"));
            order.setTotal(rs.getDouble("total"));
            list.add(order);
        }
        return list;
    }

    @Override
    public Order queryOneOrder(String order_id) throws SQLException {
        Order order=null;
        String sql="select * from `order` where order_id=?";
        rs=DBUtil.executeQuery(sql,order_id);
        while(rs.next()){
            order=new Order();
            order.setTotal(rs.getDouble("total"));
            order.setCustom_address(rs.getString("custom_address"));
            order.setCustom_phone(rs.getString("custom_phone"));
            order.setCustom_name(rs.getString("custom_name"));
            order.setManager((Manager)rs.getObject("manager"));
            order.setTime(rs.getDate("time"));
            order.setOrder_id(rs.getString("order_id"));
        }

        return order;
    }

    @Override
    public List<Order> queryAll() throws Exception {
        List<Order> list =new ArrayList<>();
        String sql="select * from `order` order by order_id desc";
        rs=DBUtil.executeQuery(sql);
        while(rs.next()){
            Order order=new Order();
            order.setOrder_id(rs.getString("order_id"));
            order.setTime(rs.getTimestamp("time"));
            order.setManager(new ManagerDaoImpl().queryManagerById(Integer.parseInt(rs.getString("manager"))));
            order.setCustom_name(rs.getString("custom_name"));
            order.setCustom_phone(rs.getString("custom_phone"));
            order.setCustom_address(rs.getString("custom_address"));
            order.setTotal(rs.getDouble("total"));
            list.add(order);
        }
        return list;
    }
}
