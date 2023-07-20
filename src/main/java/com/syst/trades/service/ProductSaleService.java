package com.syst.trades.service;

import com.syst.trades.dto.get.ProductSaleResponse;
import com.syst.trades.dto.post.ProductSaleCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.ProductSale;
import com.syst.trades.repository.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductSaleService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ProductSaleRepository repository;

    public ProductSaleResponse getById(Long id) {
        return mapperHelper.mapToProductSaleResponse(repository.findOne(id));
    }

    public List<ProductSaleResponse> getAllProductSales() {
        return mapperHelper.mapToProductSaleResponseList(repository.findAll());
    }

    public ProductSaleResponse save(ProductSaleCreate productSaleCreate) {
        ProductSale productSale = mapperHelper.mapToProductSale(productSaleCreate);
        productSale.setCreationDate(new Date());
        productSale.setUpdateDate(new Date());
        ProductSale savedProductSale = repository.save(productSale);
        return mapperHelper.mapToProductSaleResponse(savedProductSale);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}