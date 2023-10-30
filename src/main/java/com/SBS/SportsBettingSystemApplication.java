package com.SBS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SportsBettingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SportsBettingSystemApplication.class, args);
    }

}
