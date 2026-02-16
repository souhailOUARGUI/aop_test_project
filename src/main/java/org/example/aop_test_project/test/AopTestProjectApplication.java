package org.example.aop_test_project.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopTestProjectApplication.class, args);
        System.out.println("starting main app");
    }

}
