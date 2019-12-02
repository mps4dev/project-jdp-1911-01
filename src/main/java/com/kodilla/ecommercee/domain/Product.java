package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL) //TODO: for discuss
    @JoinTable(
            name = "JOIN_CART_PRODUCT",
            joinColumns = {@JoinColumn(name = "PRODUCTS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CARTS_ID")}
    )
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

}
