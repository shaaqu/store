package com.example.demo.controllers;

import com.example.demo.services.IAccountService;
import com.example.demo.services.IOrderService;
import com.example.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class IndexController {

    @Autowired
    private IProductService iProductService;

    @Autowired
    private IAccountService iAccountService;

    @Autowired
    private IOrderService iOrderService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    String index(){
        return "index";
    }
}
