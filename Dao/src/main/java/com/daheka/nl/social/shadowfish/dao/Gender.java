package com.daheka.nl.social.shadowfish.dao;

/**
 * Created by daheka on 2/10/17.
 */
public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
