package com.syst.trades.service;

import com.syst.trades.dto.get.ClientTradeResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.ClientTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTradeService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ClientTradeRepository repository;

    public List<ClientTradeResponse> getAllClientTrades() {
        return null;
//        return mapperHelper.mapToClientTrades(repository.findAll());
    }
}
