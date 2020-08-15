package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

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

    @Column(name = "orderss")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    public Account(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addOrder(Order order){
        orders.add(order);
    }
}
