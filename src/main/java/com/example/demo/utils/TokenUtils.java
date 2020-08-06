package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.pojo.User;

import java.sql.Date;

/**
 * @project: demo
 * @package: com.example.demo.utils
 * @author: wtg
 * @date Date: 2020年03月27日 下午 14:44
 * @company: 浙江绿源电动车有限公司
 * @description: token utils
 */
public class TokenUtils {
//    private static final long EXPIRE_TIME = 7*24*3600*1000;//7天

    private static final long EXPIRE_TIME = 5*60*1000;
    /**
     * 生成token
     * @param user 对象
     * @return token
     */
    public static String getToken(User user) {
        Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
        return JWT.create().withAudience(String.valueOf(user.getUser_id())).withExpiresAt(date).sign(Algorithm.HMAC256(user.getUser_pwd()));
    }
}
