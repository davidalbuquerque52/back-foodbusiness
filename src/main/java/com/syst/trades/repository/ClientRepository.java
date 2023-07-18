package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}