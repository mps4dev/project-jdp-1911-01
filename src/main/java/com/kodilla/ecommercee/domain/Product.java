package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRODUCT")
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

    @OneToMany(
            cascade = CascadeType.ALL, //TODO: for discuss
            mappedBy = "product",
            fetch = FetchType.LAZY
    )
    private List<Cart> carts;

    @OneToMany(
            cascade = CascadeType.ALL, //TODO: for discuss
            mappedBy = "product",
            fetch = FetchType.LAZY
    )
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;

}
