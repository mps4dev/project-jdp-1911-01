package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto {
    private Long id;
    private String deliveryName;
    private String deliveryLastName;
    private String deliveryAdress;
    private String deliveryHouseNumber;
    private String deliveryFlatNumber;
    private String deliveryZipCode;
    private String deliveryCity;
    private String orderComments;
    private DeliveryType deliveryType;
    private PaymentType paymentType;
    private PaymentMethod paymentMethod;
    private Cart cart;
    private Double totalPrice;
}
