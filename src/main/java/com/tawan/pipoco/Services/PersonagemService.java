package com.tawan.pipoco.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tawan.pipoco.Entidades.Personagem;
import com.tawan.pipoco.Repositorios.PersonagemRepository;

@Service
public class PersonagemService {

    private PersonagemRepository personagemRepository;

    public PersonagemService(PersonagemRepository personagemRepository) {
        this.personagemRepository = personagemRepository;
    }

    public List<Personagem> listarTodos() {
        return personagemRepository.findAll();
    }

    public Optional<Personagem> listarPorId(Long id) {
        return personagemRepository.findById(id);
    }

    public Personagem criarPersonagem(Personagem personagem) {
        return personagemRepository.save(personagem);
    }

    public Personagem atualizarPersonagem(Long id, Personagem personagem) {

        personagem.setId(id);

        return personagemRepository.save(personagem);
    }

    public void deletarPersonagem(Long id) {
        personagemRepository.deleteById(id);
    }
}