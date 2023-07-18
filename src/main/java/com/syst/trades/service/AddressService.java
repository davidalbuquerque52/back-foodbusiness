package com.syst.trades.service;

import com.syst.trades.dto.get.AddressResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private AddressRepository repository;

    public List<AddressResponse> getAllAddresses() {
        return null;
//        return mapperHelper.mapToAddresses(repository.findAll());
    }
}