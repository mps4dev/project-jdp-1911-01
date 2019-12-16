package com.kodilla.ecommercee.domain;

import lombok.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private String name;
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
    private CartDto cartDto;
    private UserDto userDto;
}
