package com.example.demo.entities;

import lombok.Builder;

import javax.persistence.*;
import java.util.List;


import org.springframework.boot.context.properties.bind.DefaultValue;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "password")
    private String password;


    @Column(name = "role")
    private String role;

    @Column(name = "orderss")
    @OneToMany(mappedBy = "account")
    private List<Order> orders;

    public Account() {}

    @Builder
    public Account(String email, String name, String surname, String nickname, String password, String role){
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrders(Order order) {
        this.orders.add(order);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
