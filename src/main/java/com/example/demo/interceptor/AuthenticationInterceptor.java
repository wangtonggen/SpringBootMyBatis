package com.example.demo.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.annotate.PassToken;
import com.example.demo.annotate.UserLoginToken;
import com.example.demo.pojo.BaseBean;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

/**
 * @project: demo
 * @package: com.example.demo.interceptor
 * @author: wtg
 * @date Date: 2020年03月27日 上午 11:33
 * @company: 浙江绿源电动车有限公司
 * @description: 拦截 token是否过期处理
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 执行认证
        if (token == null || token.length() == 0) {
            returnJson(response,401,"token失效或者不存在");
            return false;
        }
        String userId;
        try {
            userId = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            j.printStackTrace();
            System.out.println(j.getMessage());
            returnJson(response,401,"token失效或者不存在");
            return false;
        }
        User user = userService.queryUserById(userId);
        if (user == null) {
            returnJson(response,404,"用户不存在");
            return false;
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUser_pwd())).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            returnJson(response,401,"token失效或者不存在");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    /**
     * 返回json
     * @param response 响应
     * @param code 状态码
     * @param msg 状态描述
     */
    private void returnJson(HttpServletResponse response,int code,String msg){
        BaseBean<String> baseBean = new BaseBean<>();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try (PrintWriter writer = response.getWriter()) {
            baseBean.setCode(code);
            baseBean.setMsg(msg);
            writer.print(JSON.toJSONString(baseBean));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
