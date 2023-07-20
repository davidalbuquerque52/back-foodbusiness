package com.syst.trades.service;

import com.syst.trades.dto.get.AddressResponse;
import com.syst.trades.dto.post.AddressCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.Address;
import com.syst.trades.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private AddressRepository repository;

    public AddressResponse getById(Long id) {
        return mapperHelper.mapToAddressResponse(repository.findOne(id));
    }

    public List<AddressResponse> getAllAddresses() {
        return mapperHelper.mapToAddressResponseList(repository.findAll());
    }

    public AddressResponse save(AddressCreate addressCreate) {
        Address address = mapperHelper.mapToAddress(addressCreate);
        address.setCreationDate(new Date());
        address.setUpdateDate(new Date());
        Address savedAddress = repository.save(address);
        return mapperHelper.mapToAddressResponse(savedAddress);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}