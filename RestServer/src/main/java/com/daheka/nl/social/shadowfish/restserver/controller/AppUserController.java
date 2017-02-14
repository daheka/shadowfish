package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.dao.AppUser;
import com.daheka.nl.social.shadowfish.restserver.repository.AppUserRepository;
import com.daheka.nl.social.shadowfish.restserver.rest.RestPreconditions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * The rest controller for the user
 */
@RestController
public class AppUserController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AppUserController.class);

    @Autowired
    private AppUserRepository repository;

    /**
     * Rest method to get all users
     * @return A list of all users in the database
     */
    @RequestMapping( value = "/appUser", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<AppUser> findAllUsers(){
        return repository.findAll();

    }

//    /**
//     * Rest method to get one user by username
//     * @param username The name of the user
//     * @return The user that was requested
//     */
//    @RequestMapping(value="/appUser/{username}", method=RequestMethod.GET)
//    @ResponseBody
//    public AppUser findUserByName(@PathVariable("username") String username) {
//        return RestPreconditions.checkFound( repository.findByUsername( username ) );
//    }

    /**
     * Rest method to create a new user
     * @param username The username of the new user
     * @param password The password of the new user
     * @return The user that was created
     */
    @RequestMapping(value="/appUser", method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public AppUser createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        AppUser user = new AppUser(username, password);
        return repository.save(user);
    }

//    /**
//     * Rest method to update an existing user
//     * @param id The id of the to be updated user
//     * @param username The new username of the user
//     * @param password The new password of the user
//     * @return The updated user
//     */
//    @RequestMapping(value="/appUser/{id}", method=RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public AppUser updateUser(@PathVariable("id") Long id, @RequestParam("username") String username, @RequestParam("password") String password) {
//        AppUser user = RestPreconditions.checkFound(repository.findOne(id));
//        user.setUsername(username);
//        user.setPassword(password);
//        return repository.save(user);
//    }
//
//    /**
//     * Rest method to delete an existing user
//     * @param id The id of the to be deleted user
//     * @return The deleted user
//     */
//    @RequestMapping(value="/appUser/{id}", method=RequestMethod.DELETE)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public AppUser deleteUser(@PathVariable("id") Long id) {
//        AppUser user = RestPreconditions.checkFound(repository.findOne(id));
//        repository.delete(id);
//        return user;
//    }
}
