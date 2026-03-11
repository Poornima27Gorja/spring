package com.lpu.deposit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.deposit.entity.Deposit;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Integer>{

}
