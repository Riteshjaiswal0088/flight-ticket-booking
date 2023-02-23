package com.ritesh.flightticketbooking.controller;

import com.ritesh.flightticketbooking.dto.AddressDto;
import com.ritesh.flightticketbooking.dto.request.AddressRequest;
import com.ritesh.flightticketbooking.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/a1")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("/address")
    public ResponseEntity<List<AddressDto>> getAddress() {

        return ResponseEntity.ok(addressService.getAllAddresses());
    }
    @PostMapping("/address")
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressRequest addressDto) {
        AddressDto createdAddress = addressService.saveAddress(addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDto> getAddressById(@PathVariable("id") Integer id) {
        AddressDto addressDto = addressService.getAddress(id);
        return ResponseEntity.ok(addressDto);
    }

    @DeleteMapping("/address/{id}")
    public ResponseEntity<Void> deleteAddressById(@PathVariable("id") Integer id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }


}
