package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.dao.Address;
import com.daheka.nl.social.shadowfish.restserver.repository.AddressRepository;
import com.daheka.nl.social.shadowfish.restserver.rest.RestPreconditions;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daheka on 2/10/17.
 */
@RestController
public class AddressController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressRepository repository;

    @RequestMapping( value = "/address", method = RequestMethod.GET )
    @ResponseBody
    public Iterable<Address> findAllAddresses(){
        return repository.findAll();
    }

    @RequestMapping(value="/address/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Address findAddress(@PathVariable("id") Long id) {
        return RestPreconditions.checkFound( repository.findOne( id ) );
    }

    @RequestMapping(value="/address", method=RequestMethod.POST)
    @ResponseStatus( HttpStatus.CREATED )
    @ResponseBody
    public Address createAddress() {
        Address address = new Address();
        return repository.save(address);
    }
}
