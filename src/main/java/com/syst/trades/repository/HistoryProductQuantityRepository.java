package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.HistoryProductQuantity;

public interface HistoryProductQuantityRepository extends JpaRepository<HistoryProductQuantity, Long> {

}