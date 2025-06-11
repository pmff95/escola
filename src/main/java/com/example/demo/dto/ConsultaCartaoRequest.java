package com.example.demo.dto;


public record ConsultaCartaoRequest(
        String numeroCartao,
        String cpf,
        String nome
) {
}
