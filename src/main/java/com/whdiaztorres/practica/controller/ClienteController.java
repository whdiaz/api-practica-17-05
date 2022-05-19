package com.whdiaztorres.practica.controller;

import com.whdiaztorres.practica.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

@GetMapping("/clientes")
    public List<Cliente> listar(){
    Cliente cliente1 = new Cliente();
    cliente1.setId(1l);
    cliente1.setNome("gerardo3546");
    cliente1.setEmail("ge@gmail.com");
    cliente1.setTelefone("1234653");

    Cliente cliente2 = new Cliente();
    cliente2.setId(2l);
    cliente2.setNome("ronaldo");
    cliente2.setEmail("ro@gmail.com");
    cliente2.setTelefone("234432634");

     return Arrays.asList(cliente1, cliente2);



}
}
