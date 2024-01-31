package com.stringnull.rapidparcela.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "shipping_details")
public class ShippingDetails {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private int quantity;
    private BigDecimal amount;
    private String itemName;
    private String itemDetails;

}