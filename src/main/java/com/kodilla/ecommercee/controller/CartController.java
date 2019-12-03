package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.CartDto;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.ProductDto;
import com.kodilla.ecommercee.domain.ProductNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/carts")
public class CartController {

    @PostMapping
    public void create(@RequestBody CartDto cartDto) {
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return new ArrayList<>();
    }

    @PostMapping("/{cartId}")
    public void add(@RequestParam long productId, @PathVariable long cartId) throws ProductNotFoundException {
    }

    @DeleteMapping("/{cartId}")
    public void remove(@PathVariable long cartId, @RequestParam long productId) {
    }

    @PostMapping("/create")
    public OrderDto create(@RequestBody OrderDto orderDto, @RequestBody CartDto cartDto) {
        return null;
    }
}