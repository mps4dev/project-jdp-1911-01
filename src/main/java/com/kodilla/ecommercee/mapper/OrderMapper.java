package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public OrderDto mapToOrderDto(Order order) {
        return Optional.of(new OrderDto(
                order.getId(),
                order.getName(),
                order.getDescription()))
                .orElse(null);
    }

    public Order mapToOrder(OrderDto orderDto) {
        return Optional.of(new Order(
                orderDto.getId(),
                orderDto.getName(),
                orderDto.getDescription()))
                .orElse(null);
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        return orders.stream()
                .map(order -> new OrderDto(order.getId(), order.getName(), order.getDescription()))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(List<OrderDto> dtoOrders) {
        return dtoOrders.stream()
                .map(order -> new Order(order.getId(), order.getName(), order.getDescription()))
                .collect(Collectors.toList());
    }
}
