package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "PRODUCTS")
public class Product extends GenericEntity {

    public Product(Long id, String name, String description, BigDecimal price) {
        super(id, name);
        this.description = description;
        this.price = price;
    }

    public Product(Long id, String name, String description, BigDecimal price, List<Cart> carts, Group group) {
        super(id, name);
        this.description = description;
        this.price = price;
        this.carts = carts;
        this.group = group;
    }

    private String description;

    private BigDecimal price;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) //TODO: for discuss
    @JoinTable(
            name = "PRODUCT_TO_CART",
            joinColumns = {@JoinColumn(name = "PRODUCTS_ID")},
            inverseJoinColumns = {@JoinColumn(name = "CARTS_ID")}
    )
    private List<Cart> carts;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    private Group group;
}