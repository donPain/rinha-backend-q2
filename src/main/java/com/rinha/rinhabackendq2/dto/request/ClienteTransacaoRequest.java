package com.rinha.rinhabackendq2.dto.request;


import com.rinha.rinhabackendq2.model.Transacao;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteTransacaoRequest {
    @Min(1)
    private Long valor;
    private char tipo; //c = credito, d = debito
    @Length(min = 1, max = 10)
    private String descricao;

    public Transacao toEntity() {
        return Transacao.builder()
                .tipo(tipo)
                .descricao(descricao)
                .build();
    }

}
