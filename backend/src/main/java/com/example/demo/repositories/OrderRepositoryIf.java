package com.example.demo.repositories;


import com.example.demo.entities.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepositoryIf extends CrudRepository<Order, Integer>, PagingAndSortingRepository<Order, Integer> {

    Order save(Order order);

    Iterable<Order> findAll();
}
