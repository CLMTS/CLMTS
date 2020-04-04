package com.clmts.serviceImpl;

import com.clmts.dao.ProductDao;
import com.clmts.daoImpl.ProductDaoImpl;
import com.clmts.service.ProductService;
import com.clmts.util.DBUtil;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List searchProducts() {
        ProductDao productDao = new ProductDaoImpl();
        List productList = null;
        DBUtil.getConn();
        try {
            productList = productDao.queryAllProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }
}
