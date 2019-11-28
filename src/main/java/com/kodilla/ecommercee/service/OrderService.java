package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getOrders() {
        return orderMapper.mapToOrderDtoList(orderRepository.findAll());
    }

    public OrderDto getOrderById(Long id) throws OrderNotFoundException {
        Order order = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        return orderMapper.mapToOrderDto(order);
    }

    public OrderDto saveOrder(OrderDto orderDto) {
        orderRepository.save(orderMapper.mapToOrder(orderDto));
        return orderDto;
    }

    public OrderDto updateOrder(OrderDto orderDto) throws OrderNotFoundException {
        Order order = orderRepository.findById(orderDto.getId()).orElseThrow(OrderNotFoundException::new);
        order.setName(orderDto.getName());
        order.setDescription(orderDto.getDescription());
        orderRepository.save(order);
        return orderMapper.mapToOrderDto(order);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }
}
