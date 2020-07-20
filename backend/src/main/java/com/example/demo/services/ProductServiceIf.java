package com.example.demo.services;

import com.example.demo.entities.Product;

public interface ProductServiceIf {

    Product saveProduct(Product product);

    Iterable<Product> listAllProducts();
}
