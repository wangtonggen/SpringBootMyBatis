package com.example.demo.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @project: demo
 * @package: com.example.demo.annotate
 * @author: wtg
 * @date Date: 2020年03月27日 下午 13:51
 * @company: 浙江绿源电动车有限公司
 * @description: 检查是否有PassToken注释，有则跳过Token认证 直接获取数据
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassToken {
    boolean required() default true;
}
