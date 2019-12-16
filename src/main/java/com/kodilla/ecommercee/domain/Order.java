package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.GenericEntity;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    private BigDecimal totalPrice;

    @OneToOne(
            cascade = CascadeType.ALL, //TODO: for discuss
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CARTS_ID")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
}
