package com.codurance.countries.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class MyUser {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Size(min=2, max=20)
    @Column(name="username")
    private String username;

    @Size(min=2, max=20)
    @Column(name="password")
    private String password;

    public MyUser() {
    }

    public MyUser(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
