package com.example.demo.pojo;

/**
 * @project: demo
 * @package: com.example.demo.pojo
 * @author: wtg
 * @date Date: 2020年03月27日 上午 10:21
 * @company: 浙江绿源电动车有限公司
 * @description: 基础类
 */
public class BaseBean<T>{
    private int code = 1;
    private String msg = "成功";
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
