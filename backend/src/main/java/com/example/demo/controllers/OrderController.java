package com.example.demo.controllers;

import com.example.demo.entities.Order;
import com.example.demo.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
public class OrderController {

    @Autowired
    IOrderService iOrderService;

    /**
     * Save new account to database.
     */
    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody @Valid @NotNull Order order){
        iOrderService.saveNewOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * List all accounts.
     */
    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public Iterable<Order> list(Model model){
        return iOrderService.listAllOrders();
    }
}
