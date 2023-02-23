package com.ritesh.flightticketbooking.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Address {

    @Id
    @SequenceGenerator(name = "my",initialValue = 1000, allocationSize = 5)
    @GeneratedValue
    private Integer id;
    private String landMark;
    private String city;
    private String district;
    private Long pinCode;
    private String country;

}