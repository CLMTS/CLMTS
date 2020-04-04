package com.clmts.daoImpl;

import com.clmts.bean.Order_Item;
import com.clmts.dao.Order_ItemDao;
import com.clmts.util.DBUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 18:45
 */
public class Order_ItemDaoImpl implements Order_ItemDao {
    ResultSet rs=null;
    @Override
    public boolean addIteam(int product_id, double price, String order_id) throws Exception {
        int row=0;
        String sql="insert into `order_item` values(null,?,?,?)";
        row= DBUtil.executeUpdate(sql,price,product_id,order_id);
        return (row!=0)?true:false;
    }

    @Override
    public boolean delIteam(int item_id, int product_id, double price, String order_id) throws Exception {
        int row=0;
        String sql="delete from `order_item` where item_id=?";
        row= DBUtil.executeUpdate(sql,item_id);
        return (row!=0)?true:false;
    }

    @Override
    public List queryItem(String order_id) throws Exception {
        List<Order_Item> list = new ArrayList<Order_Item>();
        String sql = "select * from `order_item` where order_id = ?";
        rs=DBUtil.executeQuery(sql, order_id);
        while(rs.next()) {
            Order_Item orderItem = new Order_Item();
            orderItem.setItem_id(rs.getInt("item_id"));
            orderItem.setPrice(rs.getDouble("price"));
            orderItem.setProduct_id(rs.getInt("product_id"));
            orderItem.setOrder_id(rs.getString("order_id"));
            orderItem.setProduct(new ProductDaoImpl().queryOneProduct(rs.getInt("product_id")));
            list.add(orderItem);
        }
        return list;
}


}
