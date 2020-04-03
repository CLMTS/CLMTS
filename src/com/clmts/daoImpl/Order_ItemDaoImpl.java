package com.clmts.daoImpl;

import com.clmts.dao.Order_ItemDao;
import com.clmts.util.DBUtil;

/**
 * @author suhao
 * @create_date 2020-04-02 18:45
 */
public class Order_ItemDaoImpl implements Order_ItemDao {
    @Override
    public boolean addIteam(int item_id, int product_id, double price, String order_id) throws Exception {
        int row=0;
        String sql="insert into order_item values(?,?,?,?)";
        row= DBUtil.executeUpdate(sql,item_id,product_id,price,order_id);
        return (row!=0)?true:false;
    }

    @Override
    public boolean delIteam(int item_id, int product_id, double price, String order_id) throws Exception {
        int row=0;
        String sql="delete from order_item where item_id=?";
        row= DBUtil.executeUpdate(sql,item_id);
        return (row!=0)?true:false;
    }
}
