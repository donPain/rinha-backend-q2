package com.rinha.rinhabackendq2.handler;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;

@Configuration
public class TransactionRoute {

    @Bean
    public RouterFunction<ServerResponse> transactionRoute(TransactionHandler transactionHandler){
        return RouterFunctions.route(POST("/clientes/{id}/transacoes"), transactionHandler::createTransacaoForCliente);
    }

}
