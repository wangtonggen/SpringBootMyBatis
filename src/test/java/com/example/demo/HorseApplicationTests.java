package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @project: demo
 * @package: com.example.demo
 * @author: wtg
 * @date Date: 2020年03月25日 下午 14:47
 * @company: 浙江绿源电动车有限公司
 * @description:
 */

@SpringBootTest
public class HorseApplicationTests {
    /**
     * Spring Boot 默认已经配置好了数据源，程序员可以直接 DI 注入然后使用即可
     */
    @Resource
    DataSource dataSource;

    @Test
    public void test() {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            System.out.println("连接>>>>>>>>>" + connection);
            System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
