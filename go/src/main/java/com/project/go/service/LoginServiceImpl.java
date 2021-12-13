package com.project.go.service;

import com.project.go.repository.UsuarioRepository;
import com.project.go.security.Login;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.go.entity.Usuario;
import com.project.go.exception.Exception;

@Transactional
@Service("loginService")
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public Login tentativaErros(String username) {
        Integer tentativa = usuarioRepo.buscaTentativa(username);
        if (tentativa >= 3){
            throw new Exception("Tentativas de login ultrapassaram o limite");
        }
        usuarioRepo.salvaTentativa(tentativa+1, username);
        return null;
    }

    @Override
    public Integer buscaTentativas(String username) {
        Integer valor = usuarioRepo.buscaTentativa(username);
        return valor;
    }

    
    
}
