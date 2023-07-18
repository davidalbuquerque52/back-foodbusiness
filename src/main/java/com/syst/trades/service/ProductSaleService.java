package com.syst.trades.service;

import com.syst.trades.dto.get.ProductSaleResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductSaleService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ProductSaleRepository repository;

    public List<ProductSaleResponse> getAllProductSales() {
        return null;
//        return mapperHelper.mapToProductSales(repository.findAll());
    }
}
