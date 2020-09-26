package com.example.demo.controllers;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class OrderController {

    OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody @Valid @NotNull Order order){
        orderService.saveNewOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Iterable<Order> list(Model model){
        return orderService.listAllOrders();
    }
}
