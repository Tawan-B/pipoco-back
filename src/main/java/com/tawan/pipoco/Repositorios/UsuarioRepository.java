package com.tawan.pipoco.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawan.pipoco.Entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
