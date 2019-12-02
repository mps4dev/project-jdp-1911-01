package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    public List<OrderDto> getOrders() {
        return new ArrayList<>();
    }

    public OrderDto getOrderById(Long id) throws OrderNotFoundException {
        return new OrderDto();
    }

    public Order saveOrder(OrderDto orderDto) {
        return new Order();
    }

    public OrderDto updateOrder(OrderDto orderDto) throws OrderNotFoundException {
        return new OrderDto();
    }

    public void deleteOrderById(Long id) {

    }
}
