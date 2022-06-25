package com.example.aopprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AopPrjApplication {

    public static void main(String[] args) {
        SpringApplication.run(AopPrjApplication.class, args);
    }

}
