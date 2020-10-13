package com.example.demo.services;

import com.example.demo.entities.Order;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AccountRepository accountRepository;

    public Order saveNewOrder(String email, String productName) {
        Order order = new Order();
        order.setDate(new DateTime());
        order.setAccount(accountRepository.getAccountByEmail(email));
        order.addProduct(productRepository.findByName(productName));
        return orderRepository.save(order);
    }

    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }
}
