package com.rinha.rinhabackendq2.service;


import com.rinha.rinhabackendq2.dto.request.ClientTransactionRequest;
import com.rinha.rinhabackendq2.dto.response.ClientTransactionResponse;
import com.rinha.rinhabackendq2.repository.ClientRepository;
import com.rinha.rinhabackendq2.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final ClientRepository clientRepository;

    public Mono<ClientTransactionResponse> createTransactionForClient(Long clientId, ClientTransactionRequest body) {
        return clientRepository.findById(clientId).flatMap(c -> transactionRepository.save(body.toEntity())
                .map(ClientTransactionResponse::fromEntity));
    }
}
