package com.daxue.mybatistest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author daxue0929
 * @date 2023/7/24
 */

@SpringBootApplication
@MapperScan(basePackages = {"com.daxue.mybatistest.mapper"})
public class MybatisTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(MybatisTestApplication.class, args);
    }
}
