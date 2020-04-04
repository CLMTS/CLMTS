package com.clmts.dao;

import com.clmts.bean.Manager;

/**
 * @author suhao
 * @create_date 2020-04-02 17:46
 */
public interface ManagerDao {
    //登陆
    Manager queryManager(String uname) throws Exception;

    // 搜索
    Manager queryManagerById(int id) throws Exception;
}
