package com.daheka.nl.social.shadowfish.dao;

import javax.persistence.*;

/**
 * Created by daheka on 2/10/17.
 */
@Entity
@Table(name="profile")
public class Profile {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    @MapsId
    private AppUser appUser;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="person_id")
    @MapsId
    private Person person;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="address_id", nullable = true)
    @MapsId
    private Address address;

    public Profile() {
        // Empty constructor
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
