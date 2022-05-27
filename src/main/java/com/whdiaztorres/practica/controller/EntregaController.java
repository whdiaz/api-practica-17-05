package com.whdiaztorres.practica.controller;

import com.whdiaztorres.practica.domain.model.Entrega;
import com.whdiaztorres.practica.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody  Entrega entrega){

        return solicitacaoEntregaService.solicitar(entrega);
    }
}
