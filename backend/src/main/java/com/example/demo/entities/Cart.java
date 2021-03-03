package com.example.demo.entities;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name = "cartId")
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "cart_product",
            joinColumns = {@JoinColumn(name = "email")},
            inverseJoinColumns = {@JoinColumn(name = "productId")}
    )
    private List<Product> products = new ArrayList<Product>();

    public Cart() {}

    public Cart(String email) {
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
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
