package com.example.demo.domain.model;

import com.example.demo.domain.enums.NomeModulo;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;

import java.time.LocalDate;

@Entity
@Audited
public class EscolaModulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Escola escola;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NomeModulo modulo;

    private boolean ativo;

    private LocalDate dataAtivacao;

    private LocalDate dataExpiracao;

    public boolean isExpirado() {
        return dataExpiracao != null && dataExpiracao.isBefore(LocalDate.now());
    }

    public boolean isValido() {
        return ativo && !isExpirado();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public NomeModulo getModulo() {
        return modulo;
    }

    public void setModulo(NomeModulo modulo) {
        this.modulo = modulo;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDate getDataAtivacao() {
        return dataAtivacao;
    }

    public void setDataAtivacao(LocalDate dataAtivacao) {
        this.dataAtivacao = dataAtivacao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
