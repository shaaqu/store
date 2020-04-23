package com.example.demo.services;

import com.example.demo.entities.Product;
import com.example.demo.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository iProductRepository;

    public Product saveProduct(Product product) {
        return iProductRepository.save(product);
    }

    public Iterable<Product> listAllProducts() {
        return iProductRepository.findAll();
    }
}
