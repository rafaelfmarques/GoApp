package com.project.go.service;

import java.time.LocalDate;
import java.util.List;

import com.project.go.entity.Usuario;

public interface UsuarioService {

    public Usuario criaUsuario(String nome, String email, String senha, LocalDate dataNascimento, String telefone, 
                                String userUnico, String personalTrainer, String autorizacao, String bairro, String cidade, 
                                String logradouro, String numero, String uf);
    
    public Usuario criaAdmin(String nome, String email, String senha, LocalDate dataNascimento, String telefone, 
                            String userUnico, String autorizacao, String bairro, 
                            String cidade, String logradouro, String numero, String uf);

    public Usuario removeUsuario(Long id);
    
    public Usuario removeAdmin(Long id);

    public List<Usuario> buscarUsuarios();
    
    public Usuario buscaUsuarioPorId(Long id);


}
