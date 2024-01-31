package com.stringnull.rapidparcela.repositories;

import com.stringnull.rapidparcela.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}