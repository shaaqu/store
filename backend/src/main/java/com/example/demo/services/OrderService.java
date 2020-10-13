package com.example.demo.services;

import com.example.demo.entities.Order;



public interface OrderService {
    Order saveNewOrder(String email, String productName);

    Iterable<Order> listAllOrders();
}
