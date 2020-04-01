package com.example.demo.controller;

import com.example.demo.annotate.PassToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * author：wtg
 * date：2020/3/25 0025
 * company：浙江绿源电动车有限公司
 * desc：
 * @author Administrator
 */
@Controller
public class IndexController {
    @RequestMapping("test")
    @PassToken
    public String index(){
        return "test";
    }
}
