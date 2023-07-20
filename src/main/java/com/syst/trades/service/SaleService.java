package com.syst.trades.service;

import com.syst.trades.dto.get.SaleResponse;
import com.syst.trades.dto.post.SaleCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.Sale;
import com.syst.trades.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private SaleRepository repository;

    public SaleResponse getById(Long id) {
        return mapperHelper.mapToSaleResponse(repository.findOne(id));
    }

    public List<SaleResponse> getAllSales() {
        return mapperHelper.mapToSaleResponseList(repository.findAll());
    }

    public SaleResponse save(SaleCreate saleCreate) {
        Sale sale = mapperHelper.mapToSale(saleCreate);
        sale.setCreationDate(new Date());
        sale.setUpdateDate(new Date());
        Sale savedSale = repository.save(sale);
        return mapperHelper.mapToSaleResponse(savedSale);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}