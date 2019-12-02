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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "ADRESS")
    private String adress;

    @Column(name = "HOUSE_NUMBER")
    private String houseNumber;

    @Column(name = "FLAT_NUMBER")
    private String flatNumber;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "COMMENTS")
    private String comments;

    @Column(name = "TYPE")
    private DeliveryType deliveryType;

    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @OneToOne(
            cascade = CascadeType.ALL, //TODO: for discuss
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "CARTS_ID")
    private Cart cart;

    @Column(name = "DELIVERY_NAME")
    private Double totalPrice;
}
