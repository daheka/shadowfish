package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.dao.*;
import com.daheka.nl.social.shadowfish.restserver.repository.AddressRepository;
import com.daheka.nl.social.shadowfish.restserver.repository.PersonRepository;
import com.daheka.nl.social.shadowfish.restserver.repository.ProfileRepository;
import com.daheka.nl.social.shadowfish.restserver.repository.UserRepository;
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

    @RequestMapping(value="/profile/{user}", method=RequestMethod.GET)
    @ResponseBody
    public Profile findProfileByUser(@PathVariable(value="{user}") User user) {
        return repository.findByUser(user);
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
        User user = new User(username, password);
        Person person = new Person(firstname, lastname, age, gender);
        Address address = new Address();
        Profile profile = new Profile();
        address.setStreetName("willem kalfstraat");
        profile.setAddress(address);
        profile.setPerson(person);
        profile.setUser(user);
        return repository.save(profile);
    }

}
