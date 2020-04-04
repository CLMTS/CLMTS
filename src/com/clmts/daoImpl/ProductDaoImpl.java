package com.clmts.daoImpl;

import com.clmts.bean.Product;
import com.clmts.dao.ProductDao;
import com.clmts.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 18:46
 */
public class ProductDaoImpl implements ProductDao{
    private ResultSet rs = null;
    @Override
    public boolean addProduct(int pid, String pname, double price) throws SQLException {
        int row=0;
        String sql="insert into `product`(pid, pname, price) values(?,?,?)";
        row= DBUtil.executeUpdate(sql,pid,pname,price);
        return (row!=0)?true:false;
    }

    @Override
    public boolean delProduct(int pid) throws SQLException {
        int row=0;
        String sql="delete from `product` where pid=?";
        row=DBUtil.executeUpdate(sql,pid);
        return (row!=0)?true:false;
    }

    @Override
    public boolean updateProduct(int pid, String pname, double price) throws SQLException {
        int row=0;
        String sql="update `product` set pname=?,price=? where pid=?";
        row=DBUtil.executeUpdate(sql,pid,pname,price);
        return (row!=0)?true:false;
    }

    @Override
    public Product queryOneProduct(int pid) throws SQLException {
        Product product=null;
        String sql="select * from `product` where pid=?";
        rs=DBUtil.executeQuery(sql,pid);
        while(rs.next()){
            product=new Product();
            product.setPid(rs.getInt("pid"));
            product.setPname(rs.getString("pname"));
            product.setPrice(rs.getDouble("price"));

        }
        return product;
    }

    @Override
    public List<Product> queryAllProduct() throws SQLException {
        List<Product> list=new ArrayList<>();
        String sql="select * from `product`";
        rs=DBUtil.executeQuery(sql);
        while(rs.next()){
            Product product=new Product();
            product.setPid(rs.getInt("pid"));
            product.setPname(rs.getString("pname"));
            product.setPrice(rs.getDouble("price"));
            list.add(product);
        }
        return list;
    }
}
