package com.ritesh.flightticketbooking.dto;

import com.ritesh.flightticketbooking.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDto {

    private Integer id;
    private String name;
    private String email;
    private Address address;
}

