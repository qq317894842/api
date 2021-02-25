package com;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: HuangRui
 * @Date: 2021/2/19 14:57
 * @Description:
 */
@MapperScan({"com.mapper"})
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApiServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiServerApplication.class, args);
    }
}
