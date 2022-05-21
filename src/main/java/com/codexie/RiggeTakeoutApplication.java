package com.codexie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.codexie")
public class RiggeTakeoutApplication {

    public static void main(String[] args) {
        SpringApplication.run(RiggeTakeoutApplication.class, args);
    }

}
