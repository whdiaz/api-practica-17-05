package com.whdiaztorres.practica.domain.service;

import com.whdiaztorres.practica.domain.exception.NegocioException;
import com.whdiaztorres.practica.domain.model.Cliente;
import com.whdiaztorres.practica.domain.model.Entrega;
import com.whdiaztorres.practica.domain.model.StatusEntrega;
import com.whdiaztorres.practica.domain.repository.ClienteRepository;
import com.whdiaztorres.practica.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

     private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());


        return  entregaRepository.save(entrega);
    }
}
