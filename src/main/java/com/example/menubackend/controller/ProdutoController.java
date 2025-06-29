package com.example.menubackend.controller;

import com.example.menubackend.dto.ProdutoDTO;
import com.example.menubackend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    // ========== ENDPOINTS PARA CLIENTES ==========
    
    // Buscar produtos ativos (para exibição no cardápio)
    @GetMapping("/cardapio")
    public ResponseEntity<List<ProdutoDTO>> getCardapio() {
        List<ProdutoDTO> produtos = produtoService.findAtivos();
        return ResponseEntity.ok(produtos);
    }

    // Buscar produtos ativos por categoria
    @GetMapping("/cardapio/categoria/{categoria}")
    public ResponseEntity<List<ProdutoDTO>> getCardapioPorCategoria(@PathVariable String categoria) {
        List<ProdutoDTO> produtos = produtoService.findByCategoria(categoria);
        return ResponseEntity.ok(produtos);
    }

    // Buscar produtos ativos por nome
    @GetMapping("/cardapio/buscar")
    public ResponseEntity<List<ProdutoDTO>> buscarProdutos(@RequestParam String nome) {
        List<ProdutoDTO> produtos = produtoService.findByNome(nome);
        return ResponseEntity.ok(produtos);
    }

    // Buscar categorias únicas
    @GetMapping("/cardapio/categorias")
    public ResponseEntity<List<String>> getCategorias() {
        List<String> categorias = produtoService.findCategoriasAtivas();
        return ResponseEntity.ok(categorias);
    }

    // Buscar produto específico (ativo)
    @GetMapping("/cardapio/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoCardapio(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = produtoService.findById(id);
        if (produto.isPresent() && produto.get().getAtivo()) {
            return ResponseEntity.ok(produto.get());
        }
        return ResponseEntity.notFound().build();
    }

    // ========== ENDPOINTS ADMINISTRATIVOS ==========
    
    // Listar todos os produtos (admin)
    @GetMapping("/admin/produtos")
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        List<ProdutoDTO> produtos = produtoService.findAll();
        return ResponseEntity.ok(produtos);
    }

    // Buscar produto por ID (admin)
    @GetMapping("/admin/produtos/{id}")
    public ResponseEntity<ProdutoDTO> getProduto(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = produtoService.findById(id);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar novo produto (admin)
    @PostMapping("/admin/produtos")
    public ResponseEntity<ProdutoDTO> createProduto(@RequestBody ProdutoDTO produtoDTO) {
        ProdutoDTO novoProduto = produtoService.save(produtoDTO);
        return ResponseEntity.ok(novoProduto);
    }

    // Atualizar produto (admin)
    @PutMapping("/admin/produtos/{id}")
    public ResponseEntity<ProdutoDTO> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) {
        Optional<ProdutoDTO> produtoAtualizado = produtoService.update(id, produtoDTO);
        return produtoAtualizado.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Ativar/Desativar produto (admin)
    @PatchMapping("/admin/produtos/{id}/toggle-status")
    public ResponseEntity<ProdutoDTO> toggleStatus(@PathVariable Long id) {
        Optional<ProdutoDTO> produto = produtoService.toggleStatus(id);
        return produto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar produto (admin)
    @DeleteMapping("/admin/produtos/{id}")
    public ResponseEntity<Void> deleteProduto(@PathVariable Long id) {
        boolean deleted = produtoService.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
