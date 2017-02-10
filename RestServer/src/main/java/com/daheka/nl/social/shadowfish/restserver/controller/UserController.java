package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.restserver.repository.UserRepository;
import com.daheka.nl.social.shadowfish.dao.User;
import com.daheka.nl.social.shadowfish.restserver.rest.RestPreconditions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * The rest controller for the user
 */
@RestController
public class UserController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(UserController.class);


    @Autowired
    private UserRepository userRepository;

    /**
     * Rest method to get all users
     * @return A list of all users in the database
     */
    @RequestMapping( value = "/user", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<User> findAllUsers(){
        return userRepository.findAll();

    }

    /**
     * Rest method to get one user by username
     * @param username The name of the user
     * @return The user that was requested
     */
    @RequestMapping(value="/user/{username}", method=RequestMethod.GET)
    @ResponseBody
    public User findUserByName(@PathVariable("username") String username) {
        return RestPreconditions.checkFound( userRepository.findByUsername( username ) );
    }

    /**
     * Rest method to create a new user
     * @param username The username of the new user
     * @param password The password of the new user
     * @return The user that was created
     */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User(username, password);
        return userRepository.save(user);
    }

    /**
     * Rest method to update an existing user
     * @param id The id of the to be updated user
     * @param username The new username of the user
     * @param password The new password of the user
     * @return The updated user
     */
    @RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id, @RequestParam("username") String username, @RequestParam("password") String password) {
        User user = RestPreconditions.checkFound(userRepository.findOne(id));
        user.setUsername(username);
        user.setPassword(password);
        return userRepository.save(user);
    }

    /**
     * Rest method to delete an existing user
     * @param id The id of the to be deleted user
     * @return The deleted user
     */
    @RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User deleteUser(@PathVariable("id") Long id) {
        User user = RestPreconditions.checkFound(userRepository.findOne(id));
        userRepository.delete(id);
        return user;
    }
}
