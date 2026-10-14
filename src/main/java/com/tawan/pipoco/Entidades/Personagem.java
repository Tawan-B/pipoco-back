package com.tawan.pipoco.Entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "personagens")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personagem {

    @Id
    private String id;

    private String nome;
    private String imagem;
    private int velocidade;
    private int alcanceBomba;
    private int quantidadeBombas;
}