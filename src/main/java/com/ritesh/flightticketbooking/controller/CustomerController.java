package com.ritesh.flightticketbooking.controller;

import com.ritesh.flightticketbooking.dto.CustomerDto;
import com.ritesh.flightticketbooking.dto.request.CustomerRequest;
import com.ritesh.flightticketbooking.service.CustomerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/c1")
@RequiredArgsConstructor
@Tag(name = "CustomerController", description = "Customer management")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerDto>> getCustomer() {
        return ResponseEntity.ok( customerService.getAllCustomers());
    }

    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerRequest customerDto) {
        CustomerDto createdCustomer = customerService.saveCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Integer id) {
        CustomerDto customerDto = customerService.getCustomer(id);
        return ResponseEntity.ok(customerDto);
    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Integer id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}

