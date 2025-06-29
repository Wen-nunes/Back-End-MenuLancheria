package com.example.menubackend.repository;

import com.example.menubackend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    List<Produto> findByAtivoTrue();
    
    List<Produto> findByCategoriaAndAtivoTrue(String categoria);
    
    List<Produto> findByNomeContainingIgnoreCase(String nome);
    
    List<Produto> findByNomeContainingIgnoreCaseAndAtivoTrue(String nome);
    
    boolean existsByNome(String nome);
    
    @Query("SELECT DISTINCT p.categoria FROM Produto p WHERE p.ativo = true ORDER BY p.categoria")
    List<String> findCategoriasAtivas();
}
