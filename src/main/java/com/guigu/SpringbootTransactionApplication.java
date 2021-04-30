package com.guigu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.guigu.dao")
@SpringBootApplication
public class SpringbootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionApplication.class, args);
    }
}
