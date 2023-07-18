package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, Long>{

}