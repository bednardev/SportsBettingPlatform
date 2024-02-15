package com.sbs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@SpringBootApplication
public class SportsBettingSystemApplication {

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(SportsBettingSystemApplication.class, args);
    }

}
