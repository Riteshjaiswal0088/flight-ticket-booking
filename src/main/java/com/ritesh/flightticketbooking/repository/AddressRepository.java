package com.ritesh.flightticketbooking.repository;

import com.ritesh.flightticketbooking.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
