package com.daheka.nl.social.shadowfish.restserver.controller;

import ch.qos.logback.classic.Logger;
import com.daheka.nl.social.shadowfish.restserver.repository.ProfileRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by daheka on 2/10/17.
 */
public class ProfileController {

    private static final Logger log = (Logger) LoggerFactory.getLogger(ProfileController.class);

    @Autowired
    private ProfileRepository profileRepository;


}
