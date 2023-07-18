package com.syst.trades.service;

import com.syst.trades.dto.get.ProductResponse;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ProductRepository repository;

    public List<ProductResponse> getAllProducts() {
        return null;
//        return mapperHelper.mapToProducts(repository.findAll());
    }
}