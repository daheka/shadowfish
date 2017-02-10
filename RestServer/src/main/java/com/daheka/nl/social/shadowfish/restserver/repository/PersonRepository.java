package com.daheka.nl.social.shadowfish.restserver.repository;

import com.daheka.nl.social.shadowfish.dao.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by daheka on 2/10/17.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByName(String firstname, String lastname);
}
