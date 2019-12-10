package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import com.kodilla.ecommercee.domain.OrderNotFoundException;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getAll() {
        return orderMapper.mapToOrderDtoList(orderRepository.findAll());
    }

    public OrderDto get(long orderId) throws OrderNotFoundException {
        Order order = orderRepository.findOrThrow(orderId);
        return orderMapper.mapToOrderDto(order);
    }

    public OrderDto create(OrderDto orderDto) {
        orderRepository.save(orderMapper.mapToOrder(orderDto));
        return orderDto;
    }

    public OrderDto update(OrderDto orderDto) throws OrderNotFoundException {
        return orderMapper.mapToOrderDto(orderRepository.save(orderRepository.findOrThrow(orderMapper.mapToOrder(orderDto).getId())));
    }

    public void delete(long id) {
        orderRepository.deleteById(id);
    }
}
