package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private long id;
    private String name;
    private String lastName;
    private String address;
    private String houseNumber;
    private String flatNumber;
    private String zipCode;
    private String city;
    private String comments;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
    private CartDto cartDto;
    private BigDecimal totalPrice;
}
