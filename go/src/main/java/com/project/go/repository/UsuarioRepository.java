package com.project.go.repository;

import com.project.go.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

    public Usuario findByUserUnicoAndEmail(String userUnico, String email);
    
    public Usuario findByUserUnico(String userUnico);

    @Query("SELECT u FROM Usuario u INNER JOIN u.endereco e WHERE e.logradouro=?1")
    public Usuario buscaEnderecoPorNome(String endereco);

    @Query("SELECT u FROM Usuario u INNER JOIN u.personalTrainer pt WHERE pt.emailPersonal=?1")
    public Usuario buscaPersonalTrainerPorEmail(String personalTrainer);

    @Query(value = "SELECT tentativas_login FROM usuario WHERE usuario_unico =?1", nativeQuery = true)
    public Integer buscaTentativa(String userUnico);

    @Modifying
    @Query("update Usuario u set u.tentativasLogin = ?1 where u.userUnico = ?2")
    void salvaTentativa(Integer tentativa, String userUnico);
}
