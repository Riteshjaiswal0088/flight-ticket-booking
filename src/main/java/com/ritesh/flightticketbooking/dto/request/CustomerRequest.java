package com.ritesh.flightticketbooking.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CustomerRequest {

    private String name;
    private String email;
    private AddressRequest addressRequest;
}
