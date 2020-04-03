package com.clmts.serviceImpl;

import com.clmts.bean.Manager;
import com.clmts.dao.ManagerDao;
import com.clmts.daoImpl.ManagerDaoImpl;
import com.clmts.service.ManagerService;
import com.clmts.util.DBUtil;

import java.sql.Connection;

public class ManagerServiceImpl implements ManagerService {
    private Connection conn;
    @Override
    public int login(String uname, String upwd) {
        conn= DBUtil.getConn();
        Manager manager=null;
        ManagerDao managerDao=new ManagerDaoImpl();
        int uid=0;
        try{
            manager=managerDao.queryManager(uname);
            if(manager==null){
                return -1;
            }else if(!manager.getUpwd().equals(upwd)){
                return 0;
            }else {
                uid=manager.getUid();
            }
        }catch (Exception e){
            e.printStackTrace();}
        return uid;
    }
}
