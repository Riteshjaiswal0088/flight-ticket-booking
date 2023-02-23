package com.ritesh.flightticketbooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Integer id;
    private String landMark;
    private String city;
    private String district;
    private Long pinCode;
    private String country;

}
