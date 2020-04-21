package com.example.demo.controllers;

import com.example.demo.entities.Order;
import com.example.demo.services.IOrderService;
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
    IOrderService iOrderService;

    /**
     *Creating new
     * @param order
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Order> create(@RequestBody @Valid @NotNull Order order){
        iOrderService.saveNewOrder(order);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public Iterable<Order> list(Model model){
        return iOrderService.listAllOrders();
    }
}
