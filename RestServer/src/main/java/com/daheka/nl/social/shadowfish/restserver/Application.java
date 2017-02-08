package com.daheka.nl.social.shadowfish.restserver;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.dao.User;
import com.daheka.nl.social.shadowfish.restserver.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by daheka on 2/8/17.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = (Logger) LoggerFactory.getLogger(Application.class);

    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(final UserRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new User());
            repository.save(new User());
            repository.save(new User());

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual customer by ID
            User user = repository.findOne(1L);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch customers by last name
            log.info("Customer found with findByUsername('daheka'):");
            log.info("--------------------------------------------");
            User user2 = repository.findByUsername("daheka");
            log.info(user2.toString());
            log.info("");
        };
    }
}
