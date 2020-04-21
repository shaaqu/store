package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    IOrderRepository iOrderRepository;

    public Order saveNewOrder(Order order) {
        return iOrderRepository.save(order);
    }

    public Iterable<Order> listAllOrders() {
        return iOrderRepository.findAll();
    }
}
