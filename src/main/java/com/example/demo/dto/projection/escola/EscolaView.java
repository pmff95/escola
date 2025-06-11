package com.example.demo.dto.projection.escola;

import java.util.UUID;

import com.example.demo.domain.enums.Status;

public interface EscolaView {
    UUID getUuid();
    String getNome();
    String getCnpj();
    Status getStatus();
}
