package com.daheka.nl.social.shadowfish.restserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class that is thrown when a bad request is given
 */
@ResponseStatus( value = HttpStatus.BAD_REQUEST )
public class BadRequestException extends RuntimeException{
    //
}
