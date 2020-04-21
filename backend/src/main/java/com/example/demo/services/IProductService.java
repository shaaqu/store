package com.example.demo.services;

import com.example.demo.entities.Product;

public interface IProductService {

    Product saveProduct(Product product);

    Iterable<Product> listAllProducts();
}
