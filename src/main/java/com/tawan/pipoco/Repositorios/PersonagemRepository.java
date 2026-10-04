package com.tawan.pipoco.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tawan.pipoco.Entidades.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

}