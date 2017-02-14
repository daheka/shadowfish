package com.daheka.nl.social.shadowfish.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by daheka on 2/10/17.
 */
@Entity
@Table(name="profile")
public class Profile implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="user_id")
    @JsonManagedReference
    private AppUser appUser;
    @OneToOne(optional = false, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="person_id")
    @JsonManagedReference
    private Person person;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    @JsonManagedReference
    private Address address;

    public Profile() {
        // Empty constructor
    }

    public Profile(AppUser appUser, Person person) {
        this.appUser = appUser;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
