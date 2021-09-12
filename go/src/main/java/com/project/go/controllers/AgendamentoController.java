package com.project.go.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;
import com.project.go.entity.Agendamento;
import com.project.go.service.AgendamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agendamento")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendaService;

    @PostMapping(value = "/novo")
    @JsonView(View.Agendamento.class)
    public Agendamento cadastrarAgendamento(@RequestBody AgendamentoDto agendamento){
        
       return agendaService.criaAgendamento(agendamento.getData(), agendamento.getHorarioInicio(), agendamento.getObservacao(), agendamento.getUserUnico(), agendamento.getDiasSemana(), agendamento.getAgendamentoStatus());
    }

    
    @DeleteMapping("/excluir/{id}")
    @JsonView(View.Usuario.class)
    public Agendamento removeAgendamento(@PathVariable Long id){
        return agendaService.removeAgendamento(id);
    }

    @GetMapping(value = "/listar")
    @JsonView(View.Agendamento.class)
    public List<Agendamento> buscarUsuarios(){
        return agendaService.buscarAgendamentos();
    }
    
}
    
