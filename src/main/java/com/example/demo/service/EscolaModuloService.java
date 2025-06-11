package com.example.demo.service;

import com.example.demo.domain.model.Escola;
import com.example.demo.domain.model.EscolaModulo;
import com.example.demo.dto.AtivarModuloRequest;
import com.example.demo.exception.eureka.EurekaException;
import com.example.demo.repository.EscolaModuloRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class EscolaModuloService {


    private final EscolaModuloRepository escolaModuloRepository;

    public EscolaModuloService(EscolaModuloRepository escolaModuloRepository) {
        this.escolaModuloRepository = escolaModuloRepository;
    }

    public List<EscolaModulo> listarPorEscola(UUID escolaUuid) {
        return escolaModuloRepository.findByEscolaUuid(escolaUuid);
    }

    public EscolaModulo ativarModulo(AtivarModuloRequest request) {
        EscolaModulo relacao = new EscolaModulo();
        relacao.setEscola(new Escola(request.escolaId()));
        relacao.setModulo(request.nomeModulo());
        relacao.setAtivo(true);
        relacao.setDataAtivacao(LocalDate.now());
        relacao.setDataExpiracao(request.dataExpiracao());
        return escolaModuloRepository.save(relacao);
    }

    public void desativarModulo(Long id) {
        EscolaModulo relacao = escolaModuloRepository.findById(id)
                .orElseThrow(() -> EurekaException.ofException("Relacionamento não encontrado"));
        relacao.setAtivo(false);
        escolaModuloRepository.save(relacao);
    }
}
