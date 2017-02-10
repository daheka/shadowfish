package com.daheka.nl.social.shadowfish.restserver.controller;

/**
 * Created by daheka on 2/10/17.
 */
public class RestPreconditions {

    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
}
