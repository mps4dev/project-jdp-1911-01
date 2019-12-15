package com.kodilla.ecommercee.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCT_GROUPS")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @OneToMany(
        targetEntity = Product.class,
        mappedBy =  "group",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private List<Product> products;

    public Group(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}