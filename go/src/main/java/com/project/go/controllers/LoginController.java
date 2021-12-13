package com.project.go.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.go.JsonConfigure.View;
import com.project.go.security.JwtUtils;
import com.project.go.security.Login;
import com.project.go.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
@CrossOrigin
public class LoginController {

  @Autowired
  private AuthenticationManager authManager;

  @Autowired
  private LoginService loginService;

  @PostMapping()
  public Login autenticar(@RequestBody Login login)
      throws JsonProcessingException {

    try {
      Authentication auth = new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());
      auth = authManager.authenticate(auth);
      login.setPassword(null);
      login.setToken(JwtUtils.generateToken(auth));
      login.setAutorizacao(auth.getAuthorities().iterator().next().getAuthority());
      return login;
    } catch (Exception e) {
      return loginService.tentativaErros(login.getUsername());
    }
  }

    @GetMapping(value = "/tentativas/{username}")
    @JsonView(View.TentativasLogin.class)
    public Integer buscaPorUsername(@PathVariable("username") String username){
          return loginService.buscaTentativas(username);
      }

}
