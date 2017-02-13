package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.dao.*;
import com.daheka.nl.social.shadowfish.restserver.repository.ProfileRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daheka on 2/10/17.
 */
@RestController
public class ProfileController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileRepository repository;

    @RequestMapping( value = "/profile", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Profile> findAllProfiles(){
        return repository.findAll();
    }

    @RequestMapping(value="/profile/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Profile findProfileById(@PathVariable(value="{id}") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value="/profile/{appUser}", method=RequestMethod.GET)
    @ResponseBody
    public Profile findProfileByUser(@PathVariable(value="{appUser}") AppUser user) {
        return repository.findByAppUser(user);
    }

    @RequestMapping(value="/profile", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Profile createProfile(@RequestParam(value="username") String username,
                                 @RequestParam(value="password") String password,
                                 @RequestParam(value="firstname") String firstname,
                                 @RequestParam(value="lastname") String lastname,
                                 @RequestParam(value="age") int age,
                                 @RequestParam(value="gender") Gender gender
                                 ) {
        Person person = new Person(firstname, lastname, age, gender);
        AppUser appUser = new AppUser(username, password);
        Profile profile = new Profile();
        profile.setPerson(person);
        profile.setUser(appUser);
        return repository.save(profile);
    }

}
