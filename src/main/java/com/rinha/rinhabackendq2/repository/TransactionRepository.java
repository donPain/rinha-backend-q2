package com.rinha.rinhabackendq2.repository;


import com.rinha.rinhabackendq2.model.Transaction;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends R2dbcRepository<Transaction, Long> {
}
