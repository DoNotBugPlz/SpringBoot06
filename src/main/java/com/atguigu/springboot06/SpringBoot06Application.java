package com.atguigu.springboot06;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Dn
 */
@SpringBootApplication
//@EnableCaching
@MapperScan(basePackages = {"com.atguigu.springboot06.user.mapper"})
public class SpringBoot06Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot06Application.class, args);
    }

}
