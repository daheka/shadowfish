package com.daheka.nl.social.shadowfish.restserver.repository;

import com.daheka.nl.social.shadowfish.dao.AppUser;
import com.daheka.nl.social.shadowfish.dao.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by daheka on 2/10/17.
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

    Profile findByAppUser(AppUser appUser);
}
