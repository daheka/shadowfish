package com.daheka.nl.social.shadowfish.restserver.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class that is thrown when a resource is not found
 */
@ResponseStatus( value = HttpStatus.NOT_FOUND )
class ResourceNotFoundException extends RuntimeException{
    //
}
