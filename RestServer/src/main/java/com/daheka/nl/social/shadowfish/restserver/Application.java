package com.daheka.nl.social.shadowfish.restserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Created by daheka on 2/8/17.
 */
@SpringBootApplication
@EntityScan(value = "com.daheka.nl.social.shadowfish")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }
}
