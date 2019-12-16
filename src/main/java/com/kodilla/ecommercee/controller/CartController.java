package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.*;
import com.kodilla.ecommercee.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @PostMapping
    public void create(@RequestBody CartDto cartDto) {
        cartService.create(cartDto);
    }

    @GetMapping
    public List<ProductDto> getAll(@PathVariable long cartId) throws EntityNotFoundException {
        return cartService.getAll(cartId);
    }

    @PostMapping("/{cartId}")
    public void add(@RequestParam long productId, @PathVariable long cartId) throws EntityNotFoundException {
        cartService.add(productId, cartId);
    }

    @DeleteMapping("/{cartId}")
    public void remove(@PathVariable long cartId, @RequestParam long productId) throws EntityNotFoundException {
        cartService.remove(productId, cartId);
    }

    @PostMapping("/create")
    public OrderDto createOrder(@RequestBody CartDto cartDto) {
        return cartService.createOrder(cartDto);
    }
}