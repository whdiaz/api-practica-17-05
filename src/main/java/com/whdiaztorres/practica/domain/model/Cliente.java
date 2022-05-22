package com.whdiaztorres.practica.domain.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
public class Cliente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  nome;
    private String email;

    @Column(name = "fone")
    private String telefone;



}
