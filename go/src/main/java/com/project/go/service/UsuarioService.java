package com.project.go.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.project.go.entity.Usuario;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UsuarioService extends UserDetailsService {

    public Usuario criaUsuario(String nome, String email, String senha, LocalDate dataNascimento, String telefone,
            String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade,
            String logradouro, String numero, String uf, Float versao, Boolean ConsentimentoEndereco,
            Boolean ConsentimentoContatoEmail, Boolean ConsentimentoContatoTel, LocalDateTime criacao,
            LocalDateTime atualizado);

    public Usuario criaAdmin(String nome, String email, String senha, LocalDate dataNascimento, String telefone,
            String userUnico, String autorizacao, String bairro, String cidade, String logradouro, String numero,
            String uf, Float versao, Boolean ConsentimentoEndereco, Boolean ConsentimentoContatoEmail,
            Boolean ConsentimentoContatoTel, LocalDateTime criacao, LocalDateTime atualizado);

    public Usuario atualizaUsuario(Long id, String nome, String email, String senha, LocalDate dataNascimento,
            String telefone, String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade,
            String logradouro, String numero, String uf, Float versao, Boolean consentimentoEndereco,
            Boolean consentimentoContatoEmail, Boolean consentimentoContatoTel, LocalDateTime criacao,
            LocalDateTime atualizado);

    public Usuario atualizaAdmin(Long id, String nome, String email, String senha, LocalDate dataNascimento, String telefone,
            String userUnico, String autorizacao, String bairro, String cidade, String logradouro, String numero,
            String uf, Float versao, Boolean consentimentoEndereco, Boolean consentimentoContatoEmail,
            Boolean consentimentoContatoTel, LocalDateTime criacao, LocalDateTime atualizado);

    public Usuario removeUsuario(Long id);

    public Usuario removeAdmin(Long id);

    public List<Usuario> buscarUsuarios();

    public Usuario buscaUsuarioPorId(Long id);

    public List<Usuario> buscaUsuariosPorAutorizacao(String autorizacao);

}
