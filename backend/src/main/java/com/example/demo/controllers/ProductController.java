package com.example.demo.controllers;


import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;
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

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Creating new 'product' in database.
     * @param product
     * @return status
     */
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> create(@RequestBody @Valid @NotNull Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     *Listing all 'products' from database.
     * @param model
     * @return all 'products' from database
     */
    @RequestMapping(value = "/product", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> list(Model model) {
        return productService.listAllProducts();
    }
}
