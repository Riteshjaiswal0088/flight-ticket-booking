package com.ritesh.flightticketbooking.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String customer_not_saved) {
        super(customer_not_saved);
    }
}
