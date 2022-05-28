package com.whdiaztorres.practica.domain.service;

import com.whdiaztorres.practica.domain.exception.EntidadeNaoEncontradaException;
import com.whdiaztorres.practica.domain.model.Entrega;
import com.whdiaztorres.practica.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("entrega nao encontrada"));
    }


}
