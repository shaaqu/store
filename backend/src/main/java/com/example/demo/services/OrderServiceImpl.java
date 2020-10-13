package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    public Order saveNewOrder(Order order) {
        order.setDate(new DateTime());
        return orderRepository.save(order);
    }

    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }
}
