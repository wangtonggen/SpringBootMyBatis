package com.example.demo.service.serviceImp;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @project: demo
 * @package: com.example.demo.service.serviceImp
 * @author: wtg
 * @date Date: 2020年03月25日 下午 13:37
 * @company: 浙江绿源电动车有限公司
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String account, String pwd) {
        return userMapper.login(account,pwd);
    }

    @Override
    public User queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }

    @Override
    public User queryUserByAccount(String account) {
        return userMapper.queryUserByAccount(account);
    }

    @Override
    public boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }
}
