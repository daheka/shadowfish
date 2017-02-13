package com.daheka.nl.social.shadowfish.dao;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by daheka on 2/8/17.
 */
@Entity
@Table(name="app_user")
public class AppUser {

    @Id @GeneratedValue
    @Column(name="id")
    private Long id;
    @Column(name="username", unique=true, length=60, nullable = false)
    private String username;
    @Column(name="password", length=60, nullable=false)
    private String password;

    @XmlTransient
    @OneToOne(mappedBy = "appUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Profile profile;

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

    public Long getProfileId() {
        return profile.getId();
    }
}
