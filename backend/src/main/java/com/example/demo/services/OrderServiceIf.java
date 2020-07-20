package com.example.demo.services;

import com.example.demo.entities.Order;


public interface OrderServiceIf {
    Order saveNewOrder(Order order);

    Iterable<Order> listAllOrders();
}
