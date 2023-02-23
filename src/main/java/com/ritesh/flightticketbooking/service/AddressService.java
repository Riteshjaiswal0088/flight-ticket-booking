package com.ritesh.flightticketbooking.service;

import com.ritesh.flightticketbooking.dto.AddressDto;
import com.ritesh.flightticketbooking.dto.mapper.AddressMapper;
import com.ritesh.flightticketbooking.dto.request.AddressRequest;
import com.ritesh.flightticketbooking.entity.Address;
import com.ritesh.flightticketbooking.exception.AddressNotFoundException;
import com.ritesh.flightticketbooking.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static com.ritesh.flightticketbooking.dto.mapper.AddressMapper.ADDRESS_MAPPER;
@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;
    public AddressDto getAddress(Integer id) {
        return addressRepository.findById(id).map(addressMapper::toDTO)
                .orElseThrow(() ->
                        new AddressNotFoundException("Address not available:" +id));
        }
        public AddressDto saveAddress(AddressRequest addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        Address save = addressRepository.save(address);
        return Optional.of(save)
                .map(ADDRESS_MAPPER::toDTO)
                .orElseThrow( () ->
                        new AddressNotFoundException("Address not Saved"));
        }
        public void deleteAddress(Integer id) {
        addressRepository.findById(id).ifPresentOrElse(addressRepository::delete,
                () -> {
            throw new AddressNotFoundException("Address not found:" +id);
                });
        }
        public List<AddressDto> getAllAddresses() {
        return addressRepository.findAll().stream().map(addressMapper::toDTO)
                .collect(Collectors.toList());
        }
    }

