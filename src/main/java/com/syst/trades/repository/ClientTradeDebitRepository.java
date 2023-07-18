package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.ClientTradeDebit;

public interface ClientTradeDebitRepository extends JpaRepository<ClientTradeDebit, Long>{

}