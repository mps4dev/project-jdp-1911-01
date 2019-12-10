package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "ORDERS")
public class Order extends GenericEntity {

    private String lastName;

    private String street;

    private String houseNumber;

    private String flatNumber;

    private String zipCode;

    private String city;

    private String comments;

    private DeliveryType deliveryType;

    private PaymentType paymentType;

    @OneToOne(
            cascade = CascadeType.ALL, //TODO: for discuss
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CARTS_ID")
    private Cart cart;

    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
