package com.example.demo.services;

import com.example.demo.entities.Product;
import org.springframework.stereotype.Service;


public interface ProductServiceIf {

    Product saveProduct(Product product);

    Iterable<Product> listAllProducts();
}