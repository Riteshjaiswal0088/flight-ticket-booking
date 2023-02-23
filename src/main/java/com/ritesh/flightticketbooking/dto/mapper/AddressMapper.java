package com.ritesh.flightticketbooking.dto.mapper;

import com.ritesh.flightticketbooking.dto.AddressDto;
import com.ritesh.flightticketbooking.dto.request.AddressRequest;
import com.ritesh.flightticketbooking.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper//(componentModel = "spring")
public interface AddressMapper {

    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);
    AddressDto toDTO(Address address);

    Address toEntity(AddressDto addressDto);

    Address toEntity(AddressRequest addressRequest);

}
