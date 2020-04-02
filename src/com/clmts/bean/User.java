package com.clmts.bean;

/**
 * @author suhao
 * @create_date 2020-04-01 23:00
 */
public class User {
    private String uname;
    private String upwd;

    public User() {
    }

    public String getName() {
        return uname;
    }

    public void setName(String name) {
        this.uname = name;
    }

    public String getPwd() {
        return upwd;
    }

    public void setPwd(String pwd) {
        this.upwd = pwd;
    }
}
