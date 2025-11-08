package com.modular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.modular")
public class OrderTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderTestApplication.class, args);
    }
}
