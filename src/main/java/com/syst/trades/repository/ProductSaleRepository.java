package com.syst.trades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.Product;
import com.syst.trades.model.ProductSale;

public interface ProductSaleRepository extends JpaRepository<ProductSale, Long> {

	List<Product> findByProductName(String name);

}