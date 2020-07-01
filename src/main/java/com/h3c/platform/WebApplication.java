package com.h3c.platform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;



@SpringBootApplication
// @MapperScan("com.h3c.platform.mapper")
//@MapperScan("com.h3c.platform.*.*.dao.*")
@ComponentScan
@EnableAsync
//@EnableTransactionManagement
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}
