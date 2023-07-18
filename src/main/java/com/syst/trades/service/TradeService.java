package com.syst.trades.service;

import com.syst.trades.dto.get.TradeResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private TradeRepository repository;

    public List<TradeResponse> getAllTrades() {
        return null;
//        return mapperHelper.mapToTrades(repository.findAll());
    }
}