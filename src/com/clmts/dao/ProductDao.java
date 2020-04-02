package com.clmts.dao;

import com.clmts.bean.Product;

import java.util.List;

/**
 * @author suhao
 * @create_date 2020-04-02 17:47
 */
public interface ProductDao {
    //添加产品
    boolean addProduct(int pid,String name,double price) throws Exception;

    //删除产品
    boolean delProduct(int pid) throws Exception;

    //更新产品
    boolean updateProduct(int pid,String name,double price) throws Exception;

    //查找单个商品
    Product queryOneProduct(int pid) throws Exception;

    //查找所有商品
    List<Product> queryAllProduct() throws Exception;
}
