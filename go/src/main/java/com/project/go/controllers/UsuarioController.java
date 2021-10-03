package com.project.go.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.project.go.JsonConfigure.View;
import com.project.go.entity.Termos;
import com.project.go.entity.Usuario;
import com.project.go.service.TermosService;
import com.project.go.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usService;

    @Autowired
    TermosService termoService;

    @GetMapping(value = "/listar")
    @JsonView(View.Usuario.class)
    public List<Usuario> buscarUsuarios() {
        return usService.buscarUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario buscaPorId(@PathVariable("id") Long id) {
        return usService.buscaUsuarioPorId(id);
    }

    @PostMapping(value = "/novo")
    @JsonView(View.Usuario.class)
    public Usuario cadastrarUsuario(@RequestBody UsuarioDto usuario) {

        return usService.criaUsuario(usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                usuario.getDataNascimento(), usuario.getTelefone(), usuario.getUserUnico(), usuario.getEmailPersonal(),
                "ROLE_USER", usuario.getBairro(), usuario.getCidade(), usuario.getLogradouro(), usuario.getNumero(),
                usuario.getUfNome(), usuario.getVersao(), usuario.getConsentimentoEndereco(),
                usuario.getConsentimentoContatoEmail(), usuario.getConsentimentoContatoTel(), usuario.getCriacao(),
                usuario.getAtualizado());
    }

    @PatchMapping("/excluir/{id}")
    @JsonView(View.Usuario.class)
    public Usuario removeUsuario(@PathVariable Long id) {
        return usService.removeUsuario(id);
    }

    @PutMapping("/atualizar/{id}")
    @JsonView(View.Usuario.class)
    public Usuario atualizaUsuario(@PathVariable("id") Long id, @RequestBody UsuarioDto usuario) {

        return usService.atualizaUsuario(id, usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                usuario.getDataNascimento(), usuario.getTelefone(), usuario.getUserUnico(), usuario.getEmailPersonal(),
                "ROLE_USER", usuario.getBairro(), usuario.getCidade(), usuario.getLogradouro(), usuario.getNumero(),
                usuario.getUfNome(), usuario.getVersao(), usuario.getConsentimentoEndereco(),
                usuario.getConsentimentoContatoEmail(), usuario.getConsentimentoContatoTel(), usuario.getCriacao(),
                usuario.getAtualizado());
    }

    @PostMapping("/admin/novo")
    @JsonView(View.Usuario.class)
    public Usuario cadastrarAdmin(@RequestBody UsuarioDto usuario) {

        return usService.criaAdmin(usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                usuario.getDataNascimento(), usuario.getTelefone(), usuario.getUserUnico(), "ROLE_ADMIN",
                usuario.getBairro(), usuario.getCidade(), usuario.getLogradouro(), usuario.getNumero(),
                usuario.getUfNome(), usuario.getVersao(), usuario.getConsentimentoEndereco(),
                usuario.getConsentimentoContatoEmail(), usuario.getConsentimentoContatoTel(), usuario.getCriacao(),
                usuario.getAtualizado());
    }

    @PutMapping("/admin/atualizar/{id}")
    @JsonView(View.Usuario.class)
    public Usuario atualizaAdmin(@PathVariable("id") Long id, @RequestBody UsuarioDto usuario) {

        return usService.atualizaUsuario(id, usuario.getNome(), usuario.getEmail(), usuario.getSenha(),
                usuario.getDataNascimento(), usuario.getTelefone(), usuario.getUserUnico(), usuario.getEmailPersonal(),
                "ROLE_ADMIN", usuario.getBairro(), usuario.getCidade(), usuario.getLogradouro(), usuario.getNumero(),
                usuario.getUfNome(), usuario.getVersao(), usuario.getConsentimentoEndereco(),
                usuario.getConsentimentoContatoEmail(), usuario.getConsentimentoContatoTel(), usuario.getCriacao(),
                usuario.getAtualizado());
    }

    @PatchMapping("/admin/excluir/{id}")
    @JsonView(View.Usuario.class)
    public Usuario removeAdmin(@PathVariable Long id) {
        return usService.removeAdmin(id);
    }

    @PostMapping("/admin/termos/novo")
    public Termos cadastrarVersaoTermo(@RequestBody Termos termos) {
        return termoService.criaVersaoTermo(termos.getVersao());
    }
}
