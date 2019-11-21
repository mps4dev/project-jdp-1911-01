package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Access;
import javax.persistence.AccessType;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Access(AccessType.FIELD)
public class ProductDto {
    private String name;
    private String description;
    private float price;
}
