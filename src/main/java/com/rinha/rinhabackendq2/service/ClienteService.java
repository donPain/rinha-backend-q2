package com.rinha.rinhabackendq2.service;

import com.rinha.rinhabackendq2.dto.request.ClientTransactionRequest;
import com.rinha.rinhabackendq2.dto.response.ClientTransactionResponse;
import com.rinha.rinhabackendq2.exception.NotFoundException;
import com.rinha.rinhabackendq2.repository.ClientRepository;
import com.rinha.rinhabackendq2.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClientRepository clientRepository;
    private final TransactionRepository transactionRepository;


    public ClientTransactionResponse createTransacaoForCliente(Long clienteId, ClientTransactionRequest clienteTransacaoRequest) throws NotFoundException {
        clientRepository.findById(clienteId)
                .map(cliente -> {
                    transactionRepository.save(clienteTransacaoRequest.toEntity());

                })
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));


        return new ClientTransactionResponse();
    }

}
