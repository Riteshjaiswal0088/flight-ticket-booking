package com.ritesh.flightticketbooking.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@SuppressWarnings("ALL")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Customer {
@Id
@GeneratedValue
    private Integer id;
    private String name;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "Foreign_key_for_customer")
    private Address address;
}
