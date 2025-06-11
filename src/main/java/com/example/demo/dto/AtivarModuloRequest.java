package com.example.demo.dto;

import com.example.demo.domain.enums.NomeModulo;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record AtivarModuloRequest(
        Long escolaId,
        NomeModulo nomeModulo,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        LocalDate dataExpiracao
) {}
