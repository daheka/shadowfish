package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.dao.Gender;
import com.daheka.nl.social.shadowfish.dao.Person;
import com.daheka.nl.social.shadowfish.restserver.repository.PersonRepository;
import com.daheka.nl.social.shadowfish.restserver.rest.RestPreconditions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daheka on 2/10/17.
 */
@RestController
public class PersonController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonRepository repository;

    @RequestMapping( value = "/person", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Person> findAllUsers(){
        return repository.findAll();
    }

    @RequestMapping(value="/person/{firstname}?{lastname}", method=RequestMethod.GET)
    @ResponseBody
    public Person findUserByName(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {
        return RestPreconditions.checkFound( repository.findByName( firstname, lastname ) );
    }

    @RequestMapping(value="/person", method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Person createUser(@RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname,
                             @RequestParam("age") int age,
                             @RequestParam("gender") Gender gender) {
        Person person = new Person(firstname, lastname, age, gender);
        return repository.save(person);
    }


    @RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Person updateUser(@PathVariable("id") Long id, @RequestParam("username") String username, @RequestParam("password") String password) {
        Person person = RestPreconditions.checkFound(repository.findOne(id));
        return repository.save(person);
    }

    @RequestMapping(value="/person/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Person deleteUser(@PathVariable("profileId") Long id) {
        Person person = RestPreconditions.checkFound(repository.findOne(id));
        repository.delete(id);
        return person;
    }
}
