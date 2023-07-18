package com.syst.trades.service;

import com.syst.trades.dto.get.SaleResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private SaleRepository repository;

    public List<SaleResponse> getAllSales() {
        return null;
//        return mapperHelper.mapToSales(repository.findAll());
    }
}