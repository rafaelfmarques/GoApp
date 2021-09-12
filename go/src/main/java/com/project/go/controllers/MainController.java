package com.project.go.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MainController {

    @GetMapping(value = "/{ola}")
    public String hello(@PathVariable("ola") String nome){
        return nome;
    }
}
