package com.syst.trades.helper;

import com.syst.trades.dto.get.AddressResponse;
import com.syst.trades.dto.post.AddressCreate;
import com.syst.trades.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class MapperHelper {

    @Autowired
    private ModelMapper modelMapper;

    public AddressResponse mapToAddressResponse(Address address) {
        return Objects.isNull(address) ? null : modelMapper.map(address, AddressResponse.class);
    }

    public Address mapToAddress(AddressCreate addressCreate) {
        return modelMapper.map(addressCreate, Address.class);
    }

    public List<AddressResponse> mapToAddressResponseList(List<Address> addresses) {
        return addresses.stream().map(address -> mapToAddressResponse(address)).collect(Collectors.toList());
    }
}