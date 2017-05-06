package com.daheka.nl.social.shadowfish.restserver.repository;

import com.daheka.nl.social.shadowfish.dao.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Extension interface for the existing CrudRepository
 */
@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Long> {

    /**
     * Method to find a user by username
     * @param username The name of the user
     * @return The requested user
     */
    AppUser findByUsername(String username);
}
