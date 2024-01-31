package com.stringnull.rapidparcela.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "delivery_personel")
public class DeliveryPersonel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String password;
    private String username;
    private String lastname;
    private String firstname;
    private String middlname;
    private String email;
    private String address;
    private String contact;

    @OneToMany
    List<Shipping> shippings = new ArrayList<>();

}