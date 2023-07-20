package com.syst.trades.service;

import com.syst.trades.dto.get.ClientResponse;
import com.syst.trades.dto.post.ClientCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.Client;
import com.syst.trades.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ClientRepository repository;

    public ClientResponse getById(Long id) {
        return mapperHelper.mapToClientResponse(repository.findOne(id));
    }

    public List<ClientResponse> getAllClients() {
        return mapperHelper.mapToClientResponseList(repository.findAll());
    }

    public ClientResponse save(ClientCreate clientCreate) {
        Client client = mapperHelper.mapToClient(clientCreate);
        client.setCreationDate(new Date());
        client.setUpdateDate(new Date());
        Client savedClient = repository.save(client);
        return mapperHelper.mapToClientResponse(savedClient);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}