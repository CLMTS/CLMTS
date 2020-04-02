package com.clmts.bean;

/**
 * @author suhao
 * @create_date 2020-04-01 23:00
 */
public class Manager {
    private int uid;
    private String uname;
    private String upwd;

    public Manager() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
