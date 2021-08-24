package com.project.go.repository;

import com.project.go.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Usuario findByUserUnicoAndEmail(String userUnico, String email);

    @Query("SELECT u FROM Usuario u INNER JOIN u.endereco e WHERE e.logradouro=?1")
    public Usuario buscaEnderecoPorNome(String endereco);

    @Query("SELECT u FROM Usuario u INNER JOIN u.personalTrainer pt WHERE pt.nome=?1")
    public Usuario buscaPersonalTrainerPorNome(String personalTrainer);

}