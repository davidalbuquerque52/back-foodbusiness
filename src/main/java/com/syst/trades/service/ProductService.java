package com.syst.trades.service;

import com.syst.trades.dto.get.ProductResponse;
import com.syst.trades.dto.post.ProductCreate;
import com.syst.trades.helper.MapperHelper;
import com.syst.trades.model.Product;
import com.syst.trades.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private MapperHelper mapperHelper;

    @Autowired
    private ProductRepository repository;

    public ProductResponse getById(Long id) {
        return mapperHelper.mapToProductResponse(repository.findOne(id));
    }

    public List<ProductResponse> getAllProducts() {
        return mapperHelper.mapToProductResponseList(repository.findAll());
    }

    public ProductResponse save(ProductCreate productCreate) {
        Product product = mapperHelper.mapToProduct(productCreate);
        product.setCreationDate(new Date());
        product.setUpdateDate(new Date());
        Product savedProduct = repository.save(product);
        return mapperHelper.mapToProductResponse(savedProduct);
    }

    public void removeById(Long id) {
        repository.delete(id);
    }
}