package com.whdiaztorres.practica.controller;

import com.whdiaztorres.practica.domain.model.Cliente;
import com.whdiaztorres.practica.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

@GetMapping
    public List<Cliente> listar(){
    return clienteRepository.findAll();
   }
   @GetMapping("/{clienteId}")
   public ResponseEntity<Cliente> buscar(@PathVariable  Long clienteId){
       Optional<Cliente> cliente = clienteRepository.findById(clienteId);
       return clienteRepository.findById(clienteId)
               .map(ResponseEntity::ok)
               .orElse(ResponseEntity.notFound().build());

   }
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
   public Cliente adicionar(@Valid  @RequestBody  Cliente cliente){
        return clienteRepository.save(cliente);
   }

   @PutMapping("/{clienteId}")
    public  ResponseEntity<Cliente> atualizar(@PathVariable Long clienteId,
                         @Valid  @RequestBody Cliente cliente){
    if (!clienteRepository.existsById(clienteId)){
        return ResponseEntity.notFound().build();
    }
    cliente.setId(clienteId);
    cliente = clienteRepository.save(cliente);
    return ResponseEntity.ok(cliente);
   }

   @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId){
    if (!clienteRepository.existsById(clienteId)){
        return ResponseEntity.notFound().build();
    }
    clienteRepository.deleteById(clienteId);
    return ResponseEntity.noContent().build();
   }



}
