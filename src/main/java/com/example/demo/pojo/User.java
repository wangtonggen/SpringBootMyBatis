package com.example.demo.pojo;

/**
 * @project: demo
 * @package: com.example.demo.entity
 * @author: wtg
 * @date Date: 2020年03月25日 上午 11:17
 * @company: 浙江绿源电动车有限公司
 * @description:
 */
public class User {
    public int user_id;
    public String user_account;
    public String user_pwd;
    public String user_birthday;
    private String token;

    private String userName;
    private String msg;

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

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }

    public String getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(String user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
