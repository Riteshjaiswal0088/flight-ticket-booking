package com.ritesh.flightticketbooking.exception;

public class AddressNotFoundException extends RuntimeException {
    public AddressNotFoundException(String address_not_saveD) {
        super(address_not_saveD);
    }
}
