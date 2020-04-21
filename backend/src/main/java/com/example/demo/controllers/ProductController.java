package com.example.demo.controllers;


import com.example.demo.entities.Product;
import com.example.demo.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    IProductService iProductService;

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> list(Model model) {
        return iProductService.listAllProducts();
    }

    /**
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody @Valid @NotNull Product product) {
        iProductService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
