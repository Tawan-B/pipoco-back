package com.tawan.pipoco.Controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tawan.pipoco.Entidades.Personagem;
import com.tawan.pipoco.Services.PersonagemService;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> listarTodos() {

        return ResponseEntity.ok(personagemService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> listarPorId(@PathVariable Long id) {

        Optional<Personagem> personagem = personagemService.listarPorId(id);

        if (personagem.isPresent()) {
            return ResponseEntity.ok(personagem.get());
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem) {

        Personagem novoPersonagem = personagemService.criarPersonagem(personagem);

        return ResponseEntity.status(201).body(novoPersonagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personagem> atualizarPersonagem(@PathVariable Long id, @RequestBody Personagem personagem) {

        Personagem personagemAtualizado = personagemService.atualizarPersonagem(id, personagem);

        return ResponseEntity.ok(personagemAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPersonagem(@PathVariable Long id) {

        personagemService.deletarPersonagem(id);

        return ResponseEntity.noContent().build();
    }
}
