package com.whdiaztorres.practica.controller;

import com.whdiaztorres.practica.api.assembler.OcorrenciaAssambler;
import com.whdiaztorres.practica.api.model.input.OcorrenciaInput;
import com.whdiaztorres.practica.domain.model.Entrega;
import com.whdiaztorres.practica.domain.model.Ocorrencia;
import com.whdiaztorres.practica.domain.model.OcorrenciaModel;
import com.whdiaztorres.practica.domain.service.BuscaEntregaService;
import com.whdiaztorres.practica.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssambler ocorrenciaAssambler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());

        return ocorrenciaAssambler.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return  ocorrenciaAssambler.toCollectionModel(entrega.getOcorrencias());
    }
}
