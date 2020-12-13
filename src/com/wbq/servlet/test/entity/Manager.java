package com.wbq.servlet.test.entity;

/**
 * @ClassName Manager
 * @Description 管理员实体类
 * @Author wbq
 * @Date 2020/12/13 21:04
 * @Version 1.0
 */
public class Manager {
    private int usercode;
    private String username;

    public Manager() {
    }

    public Manager(int usercode, String username) {
        this.usercode = usercode;
        this.username = username;
    }

    public int getUsercode() {
        return usercode;
    }

    public void setUsercode(int usercode) {
        this.usercode = usercode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "usercode=" + usercode +
                ", username='" + username + '\'' +
                '}';
    }

}
