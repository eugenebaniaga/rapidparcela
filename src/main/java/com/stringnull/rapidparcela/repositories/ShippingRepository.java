package com.stringnull.rapidparcela.repositories;

import com.stringnull.rapidparcela.models.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRepository extends JpaRepository<Shipping, Long> {
}