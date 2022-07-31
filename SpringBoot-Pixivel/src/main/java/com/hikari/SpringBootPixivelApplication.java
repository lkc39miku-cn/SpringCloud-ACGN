package com.hikari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootPixivelApplication
 * @author lkc39miku_cn
 */
@MapperScan("com.hikari.mapper")
@SpringBootApplication
public class SpringBootPixivelApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootPixivelApplication.class, args);
    }
}
