package com.example.demo.repository;

import com.example.demo.domain.model.EscolaModulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EscolaModuloRepository extends JpaRepository<EscolaModulo, Long> {
    List<EscolaModulo> findByEscolaUuid(UUID escolaUuid);
}
