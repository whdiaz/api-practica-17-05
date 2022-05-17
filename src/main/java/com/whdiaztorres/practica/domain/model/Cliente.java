package com.whdiaztorres.practica.domain.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cliente {
    private Long id;
    private String  nome;
    private String email;
    private String telefone;

}
