package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "cartId")
    private String email;

    @OneToOne
    @MapsId
    @JoinColumn(name = "email")
    private Account account;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = {@JoinColumn(name = "email")},
            inverseJoinColumns = {@JoinColumn(name = "productId")}
    )
    private List<Product> products = new ArrayList<>();

    public Cart() {}

    public void setAccount(Account account) {
        this.account = account;
    }

    public void addProducts(Product product) {
        this.products.add(product);
    }

    public String getEmail() {
        return email;
    }

    public List<Product> getProducts() {
        return products;
    }
}
