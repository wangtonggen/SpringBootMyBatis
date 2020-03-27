package com.example.demo.service;

import com.example.demo.pojo.User;

/**
 * @project: demo
 * @package: com.example.demo.service
 * @author: wtg
 * @date Date: 2020年03月25日 下午 13:32
 * @company: 浙江绿源电动车有限公司
 * @description:
 */
public interface UserService {
    /**
     * 登录
     * @param account 账号
     * @param pwd 密码
     * @return 实体类
     */
    User login(String account,String pwd);

    /**
     * 根据id查询用户
     * @param userId id
     * @return 对象
     */
    User queryUserById(String userId);

    /**
     * 根据账号查询用户是否存在
     * @param account 账号
     * @return 对象
     */
    User queryUserByAccount(String account);

    /**
     * 插入数据
     * @param user 对象
     * @return true 插入成功 false插入失败
     */
    boolean insertUser(User user);
}
