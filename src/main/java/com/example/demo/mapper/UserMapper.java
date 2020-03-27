package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @project: demo
 * @package: com.example.demo.mapper
 * @author: wtg
 * @date Date: 2020年03月25日 下午 13:39
 * @company: 浙江绿源电动车有限公司
 * @description:
 */
@Mapper
public interface UserMapper {
    /**
     * 登录
     * @param account 账号
     * @param pwd 密码
     * @return 实体
     */
    User login(@Param("account") String account,@Param("pwd") String pwd);

    /**
     * 根据id查询用户
     * @param userId id
     * @return 对象
     */
    User queryUserById(@Param("userId") String userId);
    /**
     * 根据账号查询用户
     * @param account 账号
     * @return 对象
     */
    User queryUserByAccount(@Param("account") String account);

    /**
     * 插入用户
     * @param user 对象
     * @return true 插入成功 false插入失败
     */
    boolean insertUser(User user);
}
