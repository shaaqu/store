package com.example.demo.repositories;

import com.example.demo.entities.Account;
import com.example.demo.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IProductRepository extends CrudRepository<Product, Integer>, PagingAndSortingRepository<Product, Integer> {

    Product save(Product product);

    Iterable<Product> listAll();
}
