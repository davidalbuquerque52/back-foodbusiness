package com.syst.trades.service;

import com.syst.trades.dto.get.TradeResponse;
import com.syst.trades.dto.post.TradeCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.Trade;
import com.syst.trades.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TradeService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private TradeRepository repository;

    public TradeResponse getById(Integer id) {
        return mapperHelper.mapToTradeResponse(repository.findOne(id));
    }

    public List<TradeResponse> getAllTrades() {
        return mapperHelper.mapToTradeResponseList(repository.findAll());
    }

    public TradeResponse save(TradeCreate tradeCreate) {
        Trade trade = mapperHelper.mapToTrade(tradeCreate);
        trade.setCreationDate(new Date());
        trade.setUpdateDate(new Date());
        Trade savedTrade = repository.save(trade);
        return mapperHelper.mapToTradeResponse(savedTrade);
    }

    public void removeById(Integer id) {
        repository.delete(id);
    }
}