package com.example.demo.controllers;

import com.example.demo.services.AccountServiceIf;
import com.example.demo.services.OrderServiceIf;
import com.example.demo.services.ProductServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class IndexController {

    @Autowired
    private ProductServiceIf productServiceIf;

    @Autowired
    private AccountServiceIf accountServiceIf;

    @Autowired
    private OrderServiceIf orderServiceIf;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index(){
        return "index";
    }
}
