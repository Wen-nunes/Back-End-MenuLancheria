package com.example.menubackend.config;

import com.example.menubackend.model.Produto;
import com.example.menubackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void run(String... args) throws Exception {
        if (produtoRepository.count() == 0) {
            criarProdutosExemplo();
        }
    }

    private void criarProdutosExemplo() {
        Produto cocaCola = new Produto();
        cocaCola.setNome("Coca-Cola");
        cocaCola.setDescricao("Refrigerante Coca-Cola 350ml");
        cocaCola.setCategoria("Bebidas");
        cocaCola.setPreco(5.50);
        cocaCola.setImagem("https://via.placeholder.com/300x200?text=Coca-Cola");
        cocaCola.setAtivo(true);
        produtoRepository.save(cocaCola);

        Produto sucoLaranja = new Produto();
        sucoLaranja.setNome("Suco de Laranja Natural");
        sucoLaranja.setDescricao("Suco de laranja natural 300ml");
        sucoLaranja.setCategoria("Bebidas");
        sucoLaranja.setPreco(8.00);
        sucoLaranja.setImagem("https://via.placeholder.com/300x200?text=Suco+Laranja");
        sucoLaranja.setAtivo(true);
        produtoRepository.save(sucoLaranja);

        Produto agua = new Produto();
        agua.setNome("Água Mineral");
        agua.setDescricao("Água mineral 500ml");
        agua.setCategoria("Bebidas");
        agua.setPreco(3.00);
        agua.setImagem("https://via.placeholder.com/300x200?text=Agua+Mineral");
        agua.setAtivo(true);
        produtoRepository.save(agua);

        Produto xBurguer = new Produto();
        xBurguer.setNome("X-Burger");
        xBurguer.setDescricao("Hambúrguer com queijo, alface, tomate e maionese");
        xBurguer.setCategoria("Pratos Principais");
        xBurguer.setPreco(15.90);
        xBurguer.setImagem("https://via.placeholder.com/300x200?text=X-Burger");
        xBurguer.setAtivo(true);
        produtoRepository.save(xBurguer);

        Produto xSalada = new Produto();
        xSalada.setNome("X-Salada");
        xSalada.setDescricao("Hambúrguer com queijo, alface, tomate, cebola e maionese");
        xSalada.setCategoria("Pratos Principais");
        xSalada.setPreco(17.90);
        xSalada.setImagem("https://via.placeholder.com/300x200?text=X-Salada");
        xSalada.setAtivo(true);
        produtoRepository.save(xSalada);

        Produto xBacon = new Produto();
        xBacon.setNome("X-Bacon");
        xBacon.setDescricao("Hambúrguer com bacon, queijo, alface e tomate");
        xBacon.setCategoria("Pratos Principais");
        xBacon.setPreco(19.90);
        xBacon.setImagem("https://via.placeholder.com/300x200?text=X-Bacon");
        xBacon.setAtivo(true);
        produtoRepository.save(xBacon);

        Produto batataFrita = new Produto();
        batataFrita.setNome("Batata Frita");
        batataFrita.setDescricao("Porção de batatas fritas crocantes");
        batataFrita.setCategoria("Acompanhamentos");
        batataFrita.setPreco(12.00);
        batataFrita.setImagem("https://via.placeholder.com/300x200?text=Batata+Frita");
        batataFrita.setAtivo(true);
        produtoRepository.save(batataFrita);

        Produto onionRings = new Produto();
        onionRings.setNome("Onion Rings");
        onionRings.setDescricao("Anéis de cebola empanados e fritos");
        onionRings.setCategoria("Acompanhamentos");
        onionRings.setPreco(14.00);
        onionRings.setImagem("https://via.placeholder.com/300x200?text=Onion+Rings");
        onionRings.setAtivo(true);
        produtoRepository.save(onionRings);

        Produto nuggets = new Produto();
        nuggets.setNome("Nuggets de Frango");
        nuggets.setDescricao("6 unidades de nuggets de frango");
        nuggets.setCategoria("Acompanhamentos");
        nuggets.setPreco(13.00);
        nuggets.setImagem("https://via.placeholder.com/300x200?text=Nuggets");
        nuggets.setAtivo(true);
        produtoRepository.save(nuggets);

        Produto sorvete = new Produto();
        sorvete.setNome("Sorvete de Chocolate");
        sorvete.setDescricao("Sorvete de chocolate com calda");
        sorvete.setCategoria("Sobremesas");
        sorvete.setPreco(8.50);
        sorvete.setImagem("https://via.placeholder.com/300x200?text=Sorvete+Chocolate");
        sorvete.setAtivo(true);
        produtoRepository.save(sorvete);

        Produto milkshake = new Produto();
        milkshake.setNome("Milkshake de Morango");
        milkshake.setDescricao("Milkshake cremoso de morango");
        milkshake.setCategoria("Sobremesas");
        milkshake.setPreco(12.00);
        milkshake.setImagem("https://via.placeholder.com/300x200?text=Milkshake+Morango");
        milkshake.setAtivo(true);
        produtoRepository.save(milkshake);

        Produto brownie = new Produto();
        brownie.setNome("Brownie");
        brownie.setDescricao("Brownie de chocolate com sorvete");
        brownie.setCategoria("Sobremesas");
        brownie.setPreco(10.00);
        brownie.setImagem("https://via.placeholder.com/300x200?text=Brownie");
        brownie.setAtivo(true);
        produtoRepository.save(brownie);

        System.out.println("Dados de exemplo criados com sucesso!");
    }
} 