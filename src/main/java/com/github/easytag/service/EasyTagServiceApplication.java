package com.github.easytag.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class EasyTagServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyTagServiceApplication.class, args);
    }

}
