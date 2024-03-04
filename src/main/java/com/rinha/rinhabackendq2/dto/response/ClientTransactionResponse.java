package com.rinha.rinhabackendq2.dto.response;

import com.rinha.rinhabackendq2.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClientTransactionResponse {
    private Long id;
    private Long valor;
    private char tipo;
    private String descricao;

    public static ClientTransactionResponse fromEntity(Transaction transaction) {
        return new ClientTransactionResponse(transaction.getId(), transaction.getValor(), transaction.getTipo(), transaction.getDescricao());
    }
}
