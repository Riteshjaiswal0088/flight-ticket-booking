package com.ritesh.flightticketbooking.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private String landMark;
    private String city;
    private String district;
    private Long pinCode;
    private String country;
}
