package com.example.demo.controller;

import com.example.demo.annotate.PassToken;
import com.example.demo.annotate.UserLoginToken;
import com.example.demo.pojo.BaseBean;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project: demo
 * @package: com.example.demo.controller
 * @author: wtg
 * @date Date: 2020年03月25日 上午 10:49
 * @company: 浙江绿源电动车有限公司
 * @description: 用户操作的controller
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @ResponseBody
    @PassToken
    private BaseBean<User> login(String account, String password) {
        User user = userService.login(account, password);
        BaseBean<User> baseBean = new BaseBean<>();
        if (user == null) {
            baseBean.setCode(-1);
            baseBean.setMsg("用户不存在");
        } else {
            baseBean.setMsg("登录成功");
            baseBean.setCode(1);
            user.setToken(TokenUtils.getToken(user));
        }
        baseBean.setData(user);
        return baseBean;
    }

    @RequestMapping("/register")
    @ResponseBody
    @PassToken
    private BaseBean<String> register(String account, String password, String birthday) {
        BaseBean<String> baseBean = new BaseBean<>();
        if (userService.queryUserByAccount(account) != null) {
            baseBean.setCode(-1);
            baseBean.setMsg("失败");
            baseBean.setData("该账号已经存在");
        } else {
            User user = new User();
            user.setUser_account(account);
            user.setUser_pwd(password);
            user.setUser_birthday(birthday);
            if (userService.insertUser(user)) {
                baseBean.setCode(1);
                baseBean.setData("成功");
            } else {
                baseBean.setCode(-1);
                baseBean.setMsg("失败");
                baseBean.setData("注册失败");
            }
        }
        return baseBean;
    }

    /**
     * 根据id查询
     *
     * @param userId id
     * @return json
     */
    @RequestMapping("/queryUser")
    @ResponseBody
    private BaseBean<User> queryUserById(String token,String userId) {
        User user = userService.queryUserById(userId);
        BaseBean<User> baseBean = new BaseBean<>();
        if (user == null) {
            baseBean.setMsg("用户不存在");
            baseBean.setCode(-1);
        } else {
            baseBean.setMsg("成功");
            baseBean.setCode(1);
        }
        baseBean.setData(user);
        return baseBean;
    }
}
