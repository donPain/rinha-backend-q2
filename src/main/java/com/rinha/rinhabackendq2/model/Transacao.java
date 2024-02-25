package com.rinha.rinhabackendq2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @Id
    private Long id;
    private String descricao;
    private char tipo;
    private LocalDateTime realizadaEm;
}
