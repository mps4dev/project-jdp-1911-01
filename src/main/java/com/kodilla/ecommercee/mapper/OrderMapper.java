package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public OrderDto mapToOrderDto(Order order) {
        if (order == null) return null;
        return new OrderDto();
    }

    public Order mapToOrder(OrderDto orderDto) {
        if (orderDto == null) return null;
        return new Order();
    }

    public List<OrderDto> mapToOrderDtoList(List<Order> orders) {
        if (orders == null) return null;
        return orders.stream()
                .map(order -> mapToOrderDto(order))
                .collect(Collectors.toList());
    }

    public List<Order> mapToOrderList(List<OrderDto> dtoOrders) {
        if (dtoOrders == null) return null;
        return dtoOrders.stream()
                .map(order -> mapToOrder(order))
                .collect(Collectors.toList());
    }
}
