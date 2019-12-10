package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/products")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public ProductDto get(@PathVariable long productId) throws ProductNotFoundException {
        return productService.get(productId);
    }

    @PostMapping
    public void create(@RequestBody ProductDto productDto) {
        productService.create(productDto);
    }

    @PutMapping
    public ProductDto update(@RequestBody ProductDto productDto) throws ProductNotFoundException {
        return productService.update(productDto);
    }

    @DeleteMapping("/{productId}")
    public void delete(@PathVariable long productId) {
        productService.delete(productId);
    }
}
