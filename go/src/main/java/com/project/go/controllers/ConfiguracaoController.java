package com.project.go.controllers;

import com.project.go.entity.Configuracao;
import com.project.go.service.ConfiguracaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
@RequestMapping(value = "/admin")
public class ConfiguracaoController {

    @Autowired
    private ConfiguracaoService configService;

    @PutMapping("/atualizar/limite")
    public Configuracao alterarLimiteUsuarios(@RequestBody Configuracao configuracao){
        
        return configService.alteraLimite(configuracao.getId(), configuracao.getValor(), "limiteUsuarios");
     }
    
}
