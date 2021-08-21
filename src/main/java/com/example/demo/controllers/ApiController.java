package com.example.demo.controllers;

import com.example.demo.entities.Product;
import com.example.demo.exceptions.ApiException;
import com.example.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    ProductService productService;

    @Autowired
    public ApiController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(path="/product/{id}", method=RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable int id) throws ApiException {
        return new ResponseEntity<Product>(productService.getProduct(id), HttpStatus.OK);
    }

    @RequestMapping(path="/product",method = RequestMethod.POST)
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws ApiException {
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
    }

}
