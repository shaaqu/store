package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepositoryIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceIfImpl implements OrderServiceIf {

    @Autowired
    OrderRepositoryIf orderRepositoryIf;

    public Order saveNewOrder(Order order) {
        return orderRepositoryIf.save(order);
    }

    public Iterable<Order> listAllOrders() {
        return orderRepositoryIf.findAll();
    }
}
