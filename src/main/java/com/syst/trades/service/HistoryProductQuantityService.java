package com.syst.trades.service;

import com.syst.trades.dto.get.HistoryProductQuantityResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.HistoryProductQuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryProductQuantityService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private HistoryProductQuantityRepository repository;

    public List<HistoryProductQuantityResponse> getAllHistoryProductQuantities() {
        return null;
//        return mapperHelper.mapToHistoryProductQuantities(repository.findAll());
    }
}
