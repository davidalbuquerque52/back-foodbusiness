package com.syst.trades.service;

import com.syst.trades.dto.get.ClientResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ClientRepository repository;

    public List<ClientResponse> getAllAddresses() {
        return null;
//        return mapperHelper.mapToClients(repository.findAll());
    }
}
