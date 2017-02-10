package com.daheka.nl.social.shadowfish.restserver.controller;

/**
 * Condition class that checks some rest conditions
 */
public class RestPreconditions {

    /**
     * Method to check whether a resource exists
     * If the resource is not found this throws a ResourceNotFoundException
     * @param resource The resource that needs to be found
     * @param <T> The class the resource is an instance of
     * @return The resource that was found
     */
    public static <T> T checkFound(final T resource) {
        if (resource == null) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
}
