package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    public Account(String email, String name, String password) {
        this.email = email;
        this. name = name;
        this.password = password;
    }
}
