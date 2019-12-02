package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "DELIVERY_NAME")
    private String deliveryName;

    @Column(name = "DELIVERY_LASTNAME")
    private String deliveryLastName;

    @Column(name = "DELIVERY_ADRESS")
    private String deliveryAdress;

    @Column(name = "DELIVERY_HOUSE_NUMBER")
    private String deliveryHouseNumber;

    @Column(name = "DELIVERY_FLAT_NUMBER")
    private String deliveryFlatNumber;

    @Column(name = "DELIVERY_ZIP_CODE")
    private String deliveryZipCode;

    @Column(name = "DELIVERY_CITY")
    private String deliveryCity;

    @Column(name = "ORDER_COMMENTS")
    private String orderComments;

    @Column(name = "DELIVERY_TYPE")
    private DeliveryType deliveryType;

    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @Column(name = "PAYMENT_METHOD")
    private PaymentMethod paymentMethod;

    @OneToOne(
            cascade = CascadeType.ALL, //TODO: for discuss
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CARTS_ID")
    private Cart cart;

    @Column(name = "DELIVERY_NAME")
    private Double totalPrice;
}
