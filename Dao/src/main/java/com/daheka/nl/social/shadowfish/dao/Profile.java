package com.daheka.nl.social.shadowfish.dao;

import javax.persistence.*;

/**
 * Created by daheka on 2/10/17.
 */
@Entity
@Table(name="profile")
public class Profile {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;
    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="address_id")
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
