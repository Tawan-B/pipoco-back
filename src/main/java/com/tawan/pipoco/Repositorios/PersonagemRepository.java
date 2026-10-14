package com.tawan.pipoco.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tawan.pipoco.Entidades.Personagem;

public interface PersonagemRepository
        extends MongoRepository<Personagem, String> {
}