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

    @JoinColumn(name = "account") //ZAPAMIETAJ: przy @ManyToOne nie uzywaj @Column tylko @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY) //domyslnie jest eager (ładujacy ze wszystkimi polami), a chcemy lazy
    private Account account;

    @JoinColumn(name = "product")
    @OneToMany //domyslnie jest lazy(spoczko) (ladujacy tylko na żądanie)
    private List<Product> product = new ArrayList<Product>();

    public Order(){};

}
