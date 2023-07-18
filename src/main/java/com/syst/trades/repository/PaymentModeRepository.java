package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.PaymentMode;

public interface PaymentModeRepository extends JpaRepository<PaymentMode, Long>{

}