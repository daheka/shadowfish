package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.restserver.repository.UserRepository;
import com.daheka.nl.social.shadowfish.dao.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by daheka on 2/8/17.
 */
@RestController
public class UserController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping( value = "/user", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<User> findAllUsers(){
        return userRepository.findAll();

    }

    @RequestMapping(value="/user/{username}", method=RequestMethod.GET)
    @ResponseBody
    public User findUserByName(@PathVariable("username") String username) {
        return RestPreconditions.checkFound( userRepository.findByUsername( username ) );
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestParam("username") String username, @RequestParam("password") String password) {
        User user = RestPreconditions.checkFound(userRepository.findOne(id));
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User deleteUser(@PathVariable("id") Long id) {
        User user = RestPreconditions.checkFound(userRepository.findOne(id));
        userRepository.delete(id);
        return user;
    }
}
