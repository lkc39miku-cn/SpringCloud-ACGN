package com.hikari;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBootUserApplication
 *
 * @author lkc39miku_cn
 */
@MapperScan("com.hikari.mapper")
@SpringBootApplication
public class SpringBootUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootUserApplication.class, args);
    }
}
