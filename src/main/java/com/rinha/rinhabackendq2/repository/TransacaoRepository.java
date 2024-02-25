package com.rinha.rinhabackendq2.repository;


import com.rinha.rinhabackendq2.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository  extends JpaRepository<Transacao, Long> {
}
