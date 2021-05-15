package com.lemon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//自动扫描mapper，不需要每次加载是的时候指定某些mapper
@MapperScan(basePackages="com.lemon.mapper")
@EnableTransactionManagement
public class    Starter {
    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);
    }
}