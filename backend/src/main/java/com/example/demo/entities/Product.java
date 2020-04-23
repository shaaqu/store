package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    public Product(){};
}
