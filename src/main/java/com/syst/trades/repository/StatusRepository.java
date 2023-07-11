package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.Status;

public interface StatusRepository extends JpaRepository<Status, Integer>{

}
