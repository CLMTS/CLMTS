package com.clmts.daoImpl;

import com.clmts.bean.Manager;
import com.clmts.dao.ManagerDao;
import com.clmts.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author suhao
 * @create_date 2020-04-02 18:44
 */
public class ManagerDaoImpl implements ManagerDao {
    ResultSet rs=null;
    @Override
    public Manager queryManager(String uname) throws SQLException {
        Manager manager=null;
        String sql="select * from manager where username=?";
        rs=DBUtil.executeQuery(sql, uname);
        while(rs.next()){
            manager=new Manager();
            manager.setUid(rs.getInt("id"));
            manager.setUname(rs.getString("username"));
            manager.setUpwd(rs.getString("password"));
        }
        return manager;
    }
}
