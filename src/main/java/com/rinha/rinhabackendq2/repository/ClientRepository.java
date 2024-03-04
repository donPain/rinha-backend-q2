package com.rinha.rinhabackendq2.repository;

import com.rinha.rinhabackendq2.model.Cliente;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends R2dbcRepository<Cliente, Long> {
}
