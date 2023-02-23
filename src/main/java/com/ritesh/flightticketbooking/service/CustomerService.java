package com.ritesh.flightticketbooking.service;

import com.ritesh.flightticketbooking.dto.CustomerDto;
import com.ritesh.flightticketbooking.dto.mapper.CustomerMapper;
import com.ritesh.flightticketbooking.dto.request.CustomerRequest;
import com.ritesh.flightticketbooking.entity.Customer;
import com.ritesh.flightticketbooking.exception.CustomerNotFoundException;
import com.ritesh.flightticketbooking.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.ritesh.flightticketbooking.dto.mapper.CustomerMapper.CUSTOMER_MAPPER;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerDto getCustomer(Integer id) {
        log.info("This is service body");
        return customerRepository.findById(id).map(customerMapper::toDTO)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not available:"+id));
    }
    public CustomerDto saveCustomer(CustomerRequest customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        Customer save = customerRepository.save(customer);
        log.info("Customer saved:{}",save);
        return Optional.of(save)
                .map(CUSTOMER_MAPPER::toDTO)
                .orElseThrow(() ->
                        new CustomerNotFoundException("Customer not saved"));
    }

    public void deleteCustomer(Integer id) {
        customerRepository.findById(id).ifPresentOrElse(customerRepository::delete,
                () -> {
                    throw new CustomerNotFoundException("customer not found:"+id);

                });
    }

    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }
}