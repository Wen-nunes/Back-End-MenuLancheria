package com.example.menubackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;
    
    @Column(columnDefinition = "TEXT")
    private String descricao;
    
    @Column(nullable = false)
    private String categoria;
    
    @Column(nullable = false)
    private Double preco;
    
    @Column(columnDefinition = "TEXT")
    private String imagem;
    
    @Column(nullable = false)
    private Boolean ativo = true;
}
