package com.example.springboot100;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Springboot100Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot100Application.class, args);
    }

}
