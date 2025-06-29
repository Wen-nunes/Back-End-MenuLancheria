package com.example.menubackend.service;

import com.example.menubackend.dto.ProdutoDTO;
import com.example.menubackend.model.Produto;
import com.example.menubackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Converter Produto para ProdutoDTO
    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getCategoria(),
            produto.getPreco(),
            produto.getImagem(),
            produto.getAtivo()
        );
    }

    // Converter ProdutoDTO para Produto
    private Produto toEntity(ProdutoDTO dto) {
        Produto produto = new Produto();
        produto.setId(dto.getId());
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setCategoria(dto.getCategoria());
        produto.setPreco(dto.getPreco());
        produto.setImagem(dto.getImagem());
        produto.setAtivo(dto.getAtivo() != null ? dto.getAtivo() : true);
        return produto;
    }

    // Buscar todos os produtos (admin)
    public List<ProdutoDTO> findAll() {
        return produtoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar produtos ativos (cliente)
    public List<ProdutoDTO> findAtivos() {
        return produtoRepository.findByAtivoTrue()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar produto por ID
    public Optional<ProdutoDTO> findById(Long id) {
        return produtoRepository.findById(id)
                .map(this::toDTO);
    }

    // Buscar produtos ativos por categoria
    public List<ProdutoDTO> findByCategoria(String categoria) {
        return produtoRepository.findByCategoriaAndAtivoTrue(categoria)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar produtos por nome
    public List<ProdutoDTO> findByNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCaseAndAtivoTrue(nome)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Salvar produto
    public ProdutoDTO save(ProdutoDTO produtoDTO) {
        Produto produto = toEntity(produtoDTO);
        produto = produtoRepository.save(produto);
        return toDTO(produto);
    }

    // Atualizar produto
    public Optional<ProdutoDTO> update(Long id, ProdutoDTO produtoDTO) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoDTO.getNome());
                    produto.setDescricao(produtoDTO.getDescricao());
                    produto.setCategoria(produtoDTO.getCategoria());
                    produto.setPreco(produtoDTO.getPreco());
                    produto.setImagem(produtoDTO.getImagem());
                    if (produtoDTO.getAtivo() != null) {
                        produto.setAtivo(produtoDTO.getAtivo());
                    }
                    return toDTO(produtoRepository.save(produto));
                });
    }

    // Ativar/Desativar produto
    public Optional<ProdutoDTO> toggleStatus(Long id) {
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setAtivo(!produto.getAtivo());
                    return toDTO(produtoRepository.save(produto));
                });
    }

    // Deletar produto
    public boolean delete(Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Verificar se produto existe
    public boolean existsById(Long id) {
        return produtoRepository.existsById(id);
    }

    // Buscar categorias únicas
    public List<String> findCategoriasAtivas() {
        return produtoRepository.findCategoriasAtivas();
    }
} 