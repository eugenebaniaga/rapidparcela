package com.stringnull.rapidparcela.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private String firstname;
    private String middlename;

    @Column(nullable = false)
    private String contact;
    private String email;

    @Column(nullable = false)
    private String address; //should we normalize?

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments = new ArrayList<>();

    @OneToMany(mappedBy = "customer", cascade=CascadeType.ALL)
    private List<Shipping> shippings = new ArrayList<>();



}