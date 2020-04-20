package com.example.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "customer")
    @ManyToOne(fetch = FetchType.LAZY) //domyslnie jest eager, a chcemy lazy (ładujacy ze wszystkimi polami)
    private Account account;

    @OneToMany(mappedBy = "order") //domyslnie jest lazy(spoczko) (ladujacy tylko na żądanie)
    @Column(name = "product")
    private Product product;

    public Order(){};

}
