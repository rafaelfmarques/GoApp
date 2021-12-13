package com.project.go.service;

import com.project.go.entity.Usuario;
import com.project.go.security.Login;

public interface LoginService {

    public Login tentativaErros(String username);

    public Integer buscaTentativas(String username);
    
}
