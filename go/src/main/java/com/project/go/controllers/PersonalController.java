package com.project.go.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;
import com.project.go.entity.PersonalTrainer;
import com.project.go.service.PersonalTrainerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/personal")
public class PersonalController {
    
    @Autowired
    private PersonalTrainerService personalService;

    @PostMapping(value = "/novo")
    @JsonView(View.PersonalTrainer.class)
    public PersonalTrainer cadastraPersonal(@RequestBody PersonalTrainer personal){
        return personalService.criaPersonal(personal.getNome(), personal.getEmail(), personal.getFormacao());
    }

    @PutMapping(value = "/atualizar/{id}")
    @JsonView(View.PersonalTrainer.class)
    public PersonalTrainer atualizaPersonal(@PathVariable("id") Long id, @RequestBody PersonalTrainer personal){
        return personalService.atualizaPersonal(id, personal.getNome(), personal.getEmail(), personal.getFormacao());
    }

    @DeleteMapping(value = "/excluir/{id}")
    public PersonalTrainer removePersonal(@PathVariable Long id){
        return personalService.excluiPersonal(id);
    }

    @GetMapping(value = "/listar")
    @JsonView(View.PersonalTrainer.class)
    public List<PersonalTrainer> ListaPersonal(){
        return personalService.buscaPersonal();
    }
}
