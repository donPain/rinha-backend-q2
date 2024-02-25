package com.rinha.rinhabackendq2.controller;

import com.rinha.rinhabackendq2.dto.request.ClienteTransacaoRequest;
import com.rinha.rinhabackendq2.dto.response.ClienteTransacaoResponse;
import com.rinha.rinhabackendq2.exception.NotFoundException;
import com.rinha.rinhabackendq2.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;


    @PostMapping("/{id}/transacoes")
    public ResponseEntity<ClienteTransacaoResponse> createTransacaoForCliente(
            @RequestBody ClienteTransacaoRequest request,
            @PathVariable("id") Long clientId) throws NotFoundException {
        return ResponseEntity.ok(clienteService.createTransacaoForCliente(clientId, request));
    }
}
