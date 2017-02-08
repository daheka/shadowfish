package com.daheka.nl.social.shadowfish.restserver.controller;

import com.daheka.nl.social.shadowfish.restserver.repository.UserRepository;
import com.daheka.nl.social.shadowfish.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daheka on 2/8/17.
 */
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/user", method= RequestMethod.GET)
    public User getUser(@RequestParam(value="username") String username) {
        return userRepository.findByUsername(username);
    }

    @RequestMapping(value="/user", method=RequestMethod.DELETE)
    public void deleteUser(@RequestParam(value="id") Long id) {
        userRepository.delete(id);
    }

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public User createUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        User user = new User();
        return userRepository.save(user);
    }

    @RequestMapping(value="/user", method=RequestMethod.PUT)
    public void updateUser(@RequestParam(value="username") String username, @RequestParam(value="password") String password) {
        User user = userRepository.findByUsername(username);
        user.setPassword(password);
        user.setUsername(username);
        userRepository.save(user);
    }
}
