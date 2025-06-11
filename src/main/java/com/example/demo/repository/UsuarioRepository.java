package com.example.demo.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.enums.Perfil;
import com.example.demo.domain.model.Usuario;
import com.example.demo.dto.UsuarioView;
import com.example.demo.dto.projection.usuario.UsuarioFull;

@Repository
public interface UsuarioRepository extends BaseRepository<Usuario, Long> {
 
    /* Utilizado para o login */
    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.escola WHERE u.email = :email and u.status = 'ATIVO'")
    Optional<Usuario> buscarUsuarioAtivoComEscolaPorEmail(@Param("email") String email);
    
    Optional<Usuario> findByEmail(String email);

    @Query("SELECT u FROM Usuario u LEFT JOIN FETCH u.escola WHERE u.uuid = :uuid")
    Optional<Usuario> findByUuid(@Param("uuid") UUID uuid);

    boolean existsByEmail(String email);

    boolean existsByEmailAndUuidNot(String email, UUID uuid);

    boolean existsByCpf(String cpf);

    boolean existsByCpfAndUuidNot(String cpf, UUID uuid);

    Page<UsuarioView> findAllByEscolaUuid(UUID escolaId, Pageable pageable);

    @Query("""
        SELECT u FROM Usuario u
        WHERE u.escola.uuid = :escolaId
        AND u.perfil = :perfil
    """)
    Optional<UsuarioFull> findByEscolaIdAndPerfil(@Param("escolaId") UUID escolaId, @Param("perfil") Perfil perfil);


}
