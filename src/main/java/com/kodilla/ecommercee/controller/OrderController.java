package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.EntityNotFoundException;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.getAll();
    }

    @GetMapping("/{orderId}")
    public OrderDto get(@PathVariable long orderId) throws EntityNotFoundException {
        return orderService.get(orderId);
    }

    @PostMapping
    public void create(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) throws EntityNotFoundException {
        return orderService.update(orderDto);
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable long orderId) {
        orderService.delete(orderId);
    }
}
