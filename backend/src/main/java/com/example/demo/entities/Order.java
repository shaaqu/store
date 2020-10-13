package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

@Entity
@Table(name = "orderss")
public class Order {

    @Id @GeneratedValue
    @Column(name = "oreder_id")
    private int orderId;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private DateTime date;

    @ManyToOne
    @JoinColumn(name = "email", nullable = false)
    private Account account;

    @ManyToMany(mappedBy = "orders")
    private List<Product> products = new ArrayList<Product>();

    public Order(){};


    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
