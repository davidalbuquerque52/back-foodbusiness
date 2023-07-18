package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}