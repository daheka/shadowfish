package com.daheka.nl.social.shadowfish.dao;

import javax.persistence.*;

/**
 * Created by daheka on 2/10/17.
 */
@Entity
@Table(name="address")
public class Address {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="street_name")
    private String streetName;
    @Column(name="number")
    private int number;
    @Column(name="zip")
    private String zip;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    public Address() {
        // Empty constructor
    }

    public Address(String streetName, int number) {

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

    public Long getProfileId() {
        return profile.getId();
    }
}
