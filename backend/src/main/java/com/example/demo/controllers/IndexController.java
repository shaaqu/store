package com.example.demo.controllers;

import com.example.demo.services.IAccountService;
import com.example.demo.services.IOrderService;
import com.example.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IOrderService iOrderService;

    String index(){
        return "index";
    }
}
