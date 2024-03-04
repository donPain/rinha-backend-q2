package com.rinha.rinhabackendq2.handler;

import com.rinha.rinhabackendq2.dto.request.ClientTransactionRequest;
import com.rinha.rinhabackendq2.dto.response.ClientTransactionResponse;
import com.rinha.rinhabackendq2.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class TransactionHandler {
    private final TransactionService trnService;


    @Transactional
    public Mono<ServerResponse> createTransationForClient(ServerRequest request) {
        var clientId = Long.valueOf(request.pathVariable("id"));
        return request.bodyToMono(ClientTransactionRequest.class)
                .flatMap(body -> ServerResponse.ok().body(trnService.createTransactionForClient(clientId, body), ClientTransactionResponse.class));

    }


}
