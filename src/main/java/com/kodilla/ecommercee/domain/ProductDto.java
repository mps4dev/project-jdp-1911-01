package com.kodilla.ecommercee.domain;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<CartDto> dtoCarts;
    private GroupDto groupDto;
}
