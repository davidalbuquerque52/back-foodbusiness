package com.syst.trades.service;

import com.syst.trades.dto.get.ClientTradeDebitResponse;
import com.syst.trades.dto.post.ClientTradeDebitCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.ClientTradeDebit;
import com.syst.trades.repository.ClientTradeDebitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientTradeDebitService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ClientTradeDebitRepository repository;

    public ClientTradeDebitResponse getById(Long id) {
        return mapperHelper.mapToClientTradeDebitResponse(repository.findOne(id));
    }

    public List<ClientTradeDebitResponse> getAllClientTradeDebits() {
        return mapperHelper.mapToClientTradeDebitResponseList(repository.findAll());
    }

    public ClientTradeDebitResponse save(ClientTradeDebitCreate clientTradeDebitCreate) {
        ClientTradeDebit clientTradeDebit = mapperHelper.mapToClientTradeDebit(clientTradeDebitCreate);
        clientTradeDebit.setCreationDate(new Date());
        clientTradeDebit.setUpdateDate(new Date());
        ClientTradeDebit savedClientTradeDebit = repository.save(clientTradeDebit);
        return mapperHelper.mapToClientTradeDebitResponse(savedClientTradeDebit);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}