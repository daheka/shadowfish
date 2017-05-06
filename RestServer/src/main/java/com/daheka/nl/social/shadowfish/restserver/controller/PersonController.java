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
    public Iterable<Person> findAllPersons(){
        return repository.findAll();
    }

//    @RequestMapping(value="/person/{firstname}", method=RequestMethod.GET)
//    @ResponseBody
//    public Person findPersonByName(@PathVariable("firstname") String firstname) {
//        return RestPreconditions.checkFound( repository.findByFirstName( firstname ) );
//    }

    @RequestMapping(value = "/person/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Person findPersonById(@PathVariable(value="id") Long id) {
        return repository.findOne(id);
    }

    @RequestMapping(value="/person", method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Person createPerson(@RequestParam("firstname") String firstname,
                             @RequestParam("lastname") String lastname,
                             @RequestParam("age") int age,
                             @RequestParam("gender") Gender gender,
                             @RequestParam("email") String email) {
        Person person = new Person(firstname, lastname, age, gender, email);
        return repository.save(person);
    }


    @RequestMapping(value="/person/{id}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Person updatePerson(@PathVariable("id") Long id,
                               @RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname,
                               @RequestParam("age") int age,
                               @RequestParam("gender") Gender gender,
                               @RequestParam("email") String email) {
        Person person = RestPreconditions.checkFound(repository.findOne(id));
        person.setFirstName(firstname);
        person.setLastName(lastname);
        person.setAge(age);
        person.setEmail(email);
        person.setGender(gender);
        return repository.save(person);
    }

    @RequestMapping(value="/person/{id}", method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Person deletePerson(@PathVariable("id") Long id) {
        Person person = RestPreconditions.checkFound(repository.findOne(id));
        repository.delete(id);
        return person;
    }
}
