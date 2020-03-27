package com.example.demo.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project: demo
 * @package: com.example.demo.annotate
 * @author: wtg
 * @date Date: 2020年03月27日 下午 13:52
 * @company: 浙江绿源电动车有限公司
 * @description: 检查有没有需要用户权限的注解 添加注解则不需要用户权限 不添加则需要用户权限
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface UserLoginToken {
    boolean required() default true;
}
