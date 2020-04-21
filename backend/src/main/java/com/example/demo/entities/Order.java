package com.example.demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Product> product = new HashSet<Product>();

    public Order(){};

}
