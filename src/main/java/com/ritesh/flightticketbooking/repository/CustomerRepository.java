package com.ritesh.flightticketbooking.repository;

import com.ritesh.flightticketbooking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
