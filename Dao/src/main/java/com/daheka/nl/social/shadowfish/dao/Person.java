package com.daheka.nl.social.shadowfish.dao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by daheka on 2/10/17.
 */
@Entity
@Table(name="person")
public class Person {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;

    @Column(name="first_name", length=60, nullable = false)
    private String firstName;

    @Column(name="middle_name", length=60)
    private String middleName;

    @Column(name="last_name", length=60, nullable = false)
    private String lastName;

    @Column(name="age", nullable = false)
    private int age;

    @Column(name="gender", nullable = false)
    private Gender gender;

    @Column(name="email", length=100)
    private String email;

    @XmlTransient
    @OneToOne(mappedBy="person", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

    public Person(String firstName, String lastName, int age, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getProfileId() {
        return profile.getId();
    }
}
