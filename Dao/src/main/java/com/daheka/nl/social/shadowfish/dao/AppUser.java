package com.daheka.nl.social.shadowfish.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created by daheka on 2/8/17.
 */
@Entity
@Table(name="app_user")
public class AppUser implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username", unique=true, length=60, nullable = false)
    private String username;
    @Column(name="password", length=60, nullable=false)
    private String password;

    @OneToOne(mappedBy = "appUser", cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Profile profile;

    public AppUser() {
        // Empty constructor
    }

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
