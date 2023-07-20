package com.syst.trades.service;

import com.syst.trades.dto.get.ClientTradeResponse;
import com.syst.trades.dto.post.ClientTradeCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.ClientTrade;
import com.syst.trades.repository.ClientTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientTradeService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ClientTradeRepository repository;

    public ClientTradeResponse getById(Long id) {
        return mapperHelper.mapToClientTradeResponse(repository.findOne(id));
    }

    public List<ClientTradeResponse> getAllClientTrades() {
        return mapperHelper.mapToClientTradeResponseList(repository.findAll());
    }

    public ClientTradeResponse save(ClientTradeCreate clientTradeCreate) {
        ClientTrade clientTrade = mapperHelper.mapToClientTrade(clientTradeCreate);
        clientTrade.setCreationDate(new Date());
        ClientTrade savedClientTrade = repository.save(clientTrade);
        return mapperHelper.mapToClientTradeResponse(savedClientTrade);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}