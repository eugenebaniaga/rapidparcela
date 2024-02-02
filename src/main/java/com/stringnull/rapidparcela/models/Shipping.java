package com.stringnull.rapidparcela.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "shipping")
public class Shipping {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String referenceNumber; //ref no. for shipping
    private LocalDateTime shippingDate;
    //private String status;
    private BigDecimal amount;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_details_id")
    private ShippingDetails shippingDetails = new ShippingDetails();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "shipping_status_id")
    private ShippingStatus shippingStatus = new ShippingStatus();

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer = new Customer();

    @ManyToOne
    @JoinColumn(name = "delivery_personel_id")
    private DeliveryPersonel deliveryPersonel = new DeliveryPersonel();

    @OneToMany
    private List<Payment> payments = new ArrayList<>();
}