package com.simpletalk.enterprise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class SimpleTalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleTalkApplication.class, args);
    }

}
