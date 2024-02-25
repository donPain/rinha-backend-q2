package com.rinha.rinhabackendq2.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Saldo {
    @JsonProperty("saldo")
    private Long total;
    @JsonProperty("data_extrato")
    private LocalDateTime dataExtrato;
    private Long limite;
}
