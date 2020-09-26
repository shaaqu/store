package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderss")
public class Order {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @JoinColumn(name = "account")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account account;

    @Column(name = "productId")
    private int productId;

    @Column(name = "productQuantity")
    private int productQuantity;

    public Order(){};

}
