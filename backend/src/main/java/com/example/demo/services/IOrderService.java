package com.example.demo.services;

import com.example.demo.entities.Order;


public interface IOrderService {
    Order saveNewOrder(Order order);

    Iterable<Order> listAllOrders();
}
