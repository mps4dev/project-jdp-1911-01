package com.kodilla.ecommercee.domain;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Long id;
    private String name;
    private OrderDto orderDto;
    private List<ProductDto> products;
}
