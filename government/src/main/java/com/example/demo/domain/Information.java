package com.example.demo.domain;

/**
 * @作用 ：Infromation实体类
 * @CreateTime: 2019-06-14-17:19
 * @Author :杨阳
 * @ClassName :Information
 **/
public class Information {//Infromation实体类
    private int  user_id;
    private String user_name;
    private String phone;
    private String job;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    private String kind;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
