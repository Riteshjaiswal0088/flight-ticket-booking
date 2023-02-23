package com.ritesh.flightticketbooking.dto.mapper;


import com.ritesh.flightticketbooking.dto.CustomerDto;
import com.ritesh.flightticketbooking.dto.request.CustomerRequest;
import com.ritesh.flightticketbooking.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper//(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    /*@Mapping(target = "customerAddress", source = "address")*/
    CustomerDto toDTO(Customer customer);

    Customer toEntity(CustomerDto customerDto);
    @Mapping(target = "address", source = "addressRequest")
   Customer toEntity(CustomerRequest customerRequest);
}
