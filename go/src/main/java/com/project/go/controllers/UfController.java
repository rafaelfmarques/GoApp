package com.project.go.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;
import com.project.go.entity.Uf;
import com.project.go.service.UfService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/uf")
public class UfController {

    @Autowired
    private UfService ufService;
    
    @GetMapping(value = "/listar")
    @JsonView(View.Uf.class)
    public List<Uf> ListaUfs(){
        return ufService.listaUfs();
    }
}
