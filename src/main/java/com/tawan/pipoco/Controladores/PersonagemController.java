package com.tawan.pipoco.Controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tawan.pipoco.Entidades.Personagem;
import com.tawan.pipoco.Services.PersonagemService;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    private final PersonagemService personagemService;

    public PersonagemController(PersonagemService personagemService) {
        this.personagemService = personagemService;
    }

    @GetMapping
    public ResponseEntity<List<Personagem>> listarTodos() {
        return ResponseEntity.ok(personagemService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personagem> listarPorId(@PathVariable String id) {
        return personagemService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Personagem> criarPersonagem(@RequestBody Personagem personagem) {

        Personagem novoPersonagem = personagemService.criarPersonagem(personagem);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoPersonagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Personagem> atualizarPersonagem(@PathVariable String id, @RequestBody Personagem personagem) {

        return personagemService.atualizarPersonagem(id, personagem)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPersonagem(@PathVariable String id) {
        if (!personagemService.deletarPersonagem(id)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}