package com.whdiaztorres.practica.controller;

import com.whdiaztorres.practica.domain.model.Entrega;
import com.whdiaztorres.practica.domain.repository.EntregaRepository;
import com.whdiaztorres.practica.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody  Entrega entrega){

        return solicitacaoEntregaService.solicitar(entrega);
    }

    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }
    @GetMapping("/entregas")
    public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
