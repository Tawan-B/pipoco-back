package com.tawan.pipoco.Repositorios;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.tawan.pipoco.Entidades.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
}