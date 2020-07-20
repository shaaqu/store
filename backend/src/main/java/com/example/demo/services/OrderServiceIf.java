package com.example.demo.services;

import com.example.demo.entities.Order;
import org.springframework.stereotype.Service;


public interface OrderServiceIf {
    Order saveNewOrder(Order order);

    Iterable<Order> listAllOrders();
}
