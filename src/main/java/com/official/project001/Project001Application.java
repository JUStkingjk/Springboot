package com.official.project001;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.official.project001.mapper")
public class Project001Application {

    public static void main(String[] args) {
        SpringApplication.run(Project001Application.class, args);
    }

}
