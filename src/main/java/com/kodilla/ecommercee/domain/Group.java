package com.kodilla.ecommercee.domain;

import lombok.*;
import javax.persistence.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCT_GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(
        targetEntity = Product.class,
        mappedBy =  "group",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Product> products;
}