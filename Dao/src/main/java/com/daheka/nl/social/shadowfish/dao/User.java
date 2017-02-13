package com.daheka.nl.social.shadowfish.dao;

import javax.persistence.*;

/**
 * Created by daheka on 2/8/17.
 */
@Entity
@Table(name="user")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="username", unique=true, length=60, nullable = false)
    private String username;
    @Column(name="password", length=60, nullable=false)
    private String password;

    @OneToOne(mappedBy = "user")
    private Profile profile;

    public User(String username, String password) {
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

    public Long getProfileId() {
        return profile.getId();
    }
}
