package com.stringnull.rapidparcela.repositories;

import com.stringnull.rapidparcela.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}