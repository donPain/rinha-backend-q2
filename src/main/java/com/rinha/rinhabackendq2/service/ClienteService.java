package com.rinha.rinhabackendq2.service;

import com.rinha.rinhabackendq2.dto.request.ClienteTransacaoRequest;
import com.rinha.rinhabackendq2.dto.response.ClienteTransacaoResponse;
import com.rinha.rinhabackendq2.exception.NotFoundException;
import com.rinha.rinhabackendq2.model.Transacao;
import com.rinha.rinhabackendq2.repository.ClienteRepository;
import com.rinha.rinhabackendq2.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;


    public ClienteTransacaoResponse createTransacaoForCliente(Long clienteId, ClienteTransacaoRequest clienteTransacaoRequest) throws NotFoundException {
        clienteRepository.findById(clienteId)
                .map(cliente -> {
                    transacaoRepository.save(clienteTransacaoRequest.toEntity());

                })
                .orElseThrow(() -> new NotFoundException("Cliente não encontrado."));


        return new ClienteTransacaoResponse();
    }

}
