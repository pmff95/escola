package com.example.demo.controller;

import com.example.demo.domain.model.EscolaModulo;
import com.example.demo.dto.AtivarModuloRequest;
import com.example.demo.service.EscolaModuloService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/modulos")
public class EscolaModuloController {

    private final EscolaModuloService escolaModuloService;

    public EscolaModuloController(EscolaModuloService escolaModuloService) {
        this.escolaModuloService = escolaModuloService;
    }

    @GetMapping("/{escolaUuid}")
    public List<EscolaModulo> listar(@PathVariable UUID escolaUuid) {
        return escolaModuloService.listarPorEscola(escolaUuid);
    }

//    @PostMapping("/{escolaUuid}")
//    public List<EscolaModulo> salvar(@PathVariable List<String> modulos) {
//        return escolaModuloService.salvar(modulos);
//    }

    @PostMapping
    public EscolaModulo ativarModulo(@RequestBody AtivarModuloRequest request) {
        return escolaModuloService.ativarModulo(request);
    }

    @DeleteMapping("/{id}")
    public void desativar(@PathVariable Long id) {
        escolaModuloService.desativarModulo(id);
    }
}
