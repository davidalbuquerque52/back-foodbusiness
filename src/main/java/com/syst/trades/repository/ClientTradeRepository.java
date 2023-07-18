package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.ClientTrade;

public interface ClientTradeRepository extends JpaRepository<ClientTrade, Long> {

}