package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private List<CartDto> dtoCarts;
    private GroupDto groupDto;
}
