package com.syst.trades.service;

import com.syst.trades.dto.get.ClientTradeDebitResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.ClientTradeDebitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTradeDebitService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ClientTradeDebitRepository repository;

    public List<ClientTradeDebitResponse> getAllClientTradeDebits() {
        return null;
//        return mapperHelper.mapToClientTradeDebits(repository.findAll());
    }
}
