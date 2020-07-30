package com.kingland.Springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @describe: main class
 */
@SpringBootApplication
@MapperScan("com.kingland.Springboot.mapper")
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

/*

 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.

 */