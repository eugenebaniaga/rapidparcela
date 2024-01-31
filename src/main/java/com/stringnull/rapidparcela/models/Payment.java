package com.stringnull.rapidparcela.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private BigDecimal amount;
    private String paymentType;
    private String referenceNumber; //ref no. for payment;
    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer = new Customer();

    @ManyToOne
    private Shipping shipping = new Shipping();
}