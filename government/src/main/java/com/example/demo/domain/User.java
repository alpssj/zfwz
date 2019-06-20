package com.example.demo.domain;

import com.sun.javafx.beans.IDProperty;

/**
 * @作用 ：Userbean
 * @CreateTime: 2019-06-11-10:45
 * @Author :杨阳
 * @ClassName :user
 **/
public class User {//Userbean

    private int user_id;
    private String user_account;
    private String user_password;
    private String user_name;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
