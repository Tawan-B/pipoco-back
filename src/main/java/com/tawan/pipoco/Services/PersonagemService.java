package com.tawan.pipoco.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tawan.pipoco.Entidades.Personagem;
import com.tawan.pipoco.Repositorios.PersonagemRepository;

@Service
public class PersonagemService {

    private final PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    public Optional<Personagem> listarPorId(String id) {
        return personagemRepository.findById(id);
    }

    public Personagem criarPersonagem(Personagem personagem) {
        personagem.setId(null);
        return personagemRepository.save(personagem);
    }

    public Optional<Personagem> atualizarPersonagem(
            String id, Personagem personagem) {

        return personagemRepository.findById(id).map(personagemExistente -> {
            personagem.setId(id);
            return personagemRepository.save(personagem);
        });
    }

    public boolean deletarPersonagem(String id) {
        if (!personagemRepository.existsById(id)) {
            return false;
        }

        personagemRepository.deleteById(id);
        return true;
    }
}