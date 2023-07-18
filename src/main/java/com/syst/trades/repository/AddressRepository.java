package com.syst.trades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.syst.trades.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}