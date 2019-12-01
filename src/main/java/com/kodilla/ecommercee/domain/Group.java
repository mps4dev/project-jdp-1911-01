package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRODUCT_GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
        targetEntity = Product.class,
        mappedBy =  "group",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Product> getProducts = new ArrayList<>();
}