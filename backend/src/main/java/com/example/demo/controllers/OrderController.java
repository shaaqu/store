package com.example.demo.controllers;

import com.example.demo.entities.Order;
import com.example.demo.services.OrderServiceIf;
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

    @Autowired
    OrderServiceIf orderServiceIf;

    /**
     *Creating new 'order' in database.
     * @param order
     * @return status
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody @Valid @NotNull Order order){
        orderServiceIf.saveNewOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     *Listing all 'orders' from database
     * @param model
     * @return all 'orders' from database
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Iterable<Order> list(Model model){
        return orderServiceIf.listAllOrders();
    }
}
