package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.service.OrderService;
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

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping(value = "/{orderId}")
    public OrderDto get(@PathVariable long orderId) throws OrderNotFoundException {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public void create(@RequestBody OrderDto orderDto) {
        orderService.saveOrder(orderDto);
    }

    @PutMapping
    public OrderDto update(@RequestBody OrderDto orderDto) throws OrderNotFoundException {
        return orderService.updateOrder(orderDto);
    }

    @DeleteMapping(value = "/{orderId}")
    public void delete(@PathVariable long orderId) {
        orderService.deleteOrderById(orderId);
    }
}
