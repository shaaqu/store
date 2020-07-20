package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepositoryIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceIfImpl implements ProductServiceIf {

    @Autowired
    ProductRepositoryIf productRepositoryIf;

    public Product saveProduct(Product product) {
        return productRepositoryIf.save(product);
    }

    public Iterable<Product> listAllProducts() {
        return productRepositoryIf.findAll();
    }
}
