package com.whdiaztorres.practica.domain.service;

import com.whdiaztorres.practica.domain.exception.NegocioException;
import com.whdiaztorres.practica.domain.model.Cliente;
import com.whdiaztorres.practica.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw  new NegocioException("ja existe um cliente cadastrado com este e-mail.");
        }
        return clienteRepository.save(cliente);


    }
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }


}
