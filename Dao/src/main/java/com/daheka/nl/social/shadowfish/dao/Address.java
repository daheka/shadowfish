package com.daheka.nl.social.shadowfish.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by daheka on 2/10/17.
 */
@Entity
@Table(name="address")
public class Address implements Serializable {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="street_name")
    private String streetName;
    @Column(name="number")
    private int number;
    @Column(name="zip")
    private String zip;

    @OneToMany(mappedBy="address", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private List<Profile> profiles;

    public Address() {
        // Empty constructor
    }

    public Address(String streetName, int number, String zip) {
        this.streetName = streetName;
        this.number = number;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }
}
