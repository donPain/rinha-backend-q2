package com.rinha.rinhabackendq2.service;


import com.rinha.rinhabackendq2.model.Transacao;
import com.rinha.rinhabackendq2.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;
}
