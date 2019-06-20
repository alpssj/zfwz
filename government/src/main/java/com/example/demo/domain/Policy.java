package com.example.demo.domain;


/**
 * @作用 ：policy
 * @CreateTime: 2019-06-15-15:25
 * @Author :杨阳
 * @ClassName :policy
 **/
public class Policy {//policy
    private int  policy_id;
    private String policy_name;
    private String policy_link;
    private String department;

    public int getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(int policy_id) {
        this.policy_id = policy_id;
    }

    public String getPolicy_name() {
        return policy_name;
    }

    public void setPolicy_name(String policy_name) {
        this.policy_name = policy_name;
    }

    public String getPolicy_link() {
        return policy_link;
    }

    public void setPolicy_link(String policy_link) {
        this.policy_link = policy_link;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

