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
        cocaCola.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS36LYVzn1dZ_UO_LZSrFU0HwfYdo8_hCtZ2Q&s");
        cocaCola.setAtivo(true);
        produtoRepository.save(cocaCola);

        Produto sucoLaranja = new Produto();
        sucoLaranja.setNome("Suco de Laranja Natural");
        sucoLaranja.setDescricao("Suco de laranja natural 300ml");
        sucoLaranja.setCategoria("Bebidas");
        sucoLaranja.setPreco(8.00);
        sucoLaranja.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8hX6hafWvBHrZdlCH3SrF402Mgp497HziTA&s");
        sucoLaranja.setAtivo(true);
        produtoRepository.save(sucoLaranja);

        Produto agua = new Produto();
        agua.setNome("Água Mineral");
        agua.setDescricao("Água mineral 500ml");
        agua.setCategoria("Bebidas");
        agua.setPreco(3.00);
        agua.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRqRk0gp1RnajWeWVSlI8FbZsSDur_2BArbMA&s");
        agua.setAtivo(true);
        produtoRepository.save(agua);

        Produto aguaDeCoco = new Produto();
        aguaDeCoco.setNome("Água de Coco");
        aguaDeCoco.setDescricao("Água de Coco 500ml");
        aguaDeCoco.setCategoria("Bebidas");
        aguaDeCoco.setPreco(13.00);
        aguaDeCoco.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ0Bh9q29oFbBRM_cuQx-YIlwBdvQuNrhbN_g&s");
        aguaDeCoco.setAtivo(true);
        produtoRepository.save(aguaDeCoco);

        Produto xBurguer = new Produto();
        xBurguer.setNome("X-Burger");
        xBurguer.setDescricao("Hambúrguer com queijo, alface, tomate e maionese");
        xBurguer.setCategoria("Pratos Principais");
        xBurguer.setPreco(15.90);
        xBurguer.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTw427zt8x4STsQpOrREfup76RU4sNcVM2pXA&s");
        xBurguer.setAtivo(true);
        produtoRepository.save(xBurguer);

        Produto xSalada = new Produto();
        xSalada.setNome("X-Salada");
        xSalada.setDescricao("Hambúrguer com queijo, alface, tomate, cebola e maionese");
        xSalada.setCategoria("Pratos Principais");
        xSalada.setPreco(17.90);
        xSalada.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcVvN9T7XTgFkREroRuZeVE1CgFoKIzxvr3w&s");
        xSalada.setAtivo(true);
        produtoRepository.save(xSalada);

        Produto xBacon = new Produto();
        xBacon.setNome("X-Bacon");
        xBacon.setDescricao("Hambúrguer com bacon, queijo, alface e tomate");
        xBacon.setCategoria("Pratos Principais");
        xBacon.setPreco(19.90);
        xBacon.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYemRAnLy5QAMHCqOp2kZ-yAO_S3QfAG3IpQ&s");
        xBacon.setAtivo(true);
        produtoRepository.save(xBacon);

        Produto xCompleto = new Produto();
        xCompleto.setNome("XCompleto");
        xCompleto.setDescricao("Bife, ovo, cebola caramelizada, queijo, presunto, salada");
        xCompleto.setCategoria("Pratos Principais");
        xCompleto.setPreco(12.00);
        xCompleto.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-9KZjBIEaRXsNZLyOXGgVPuc9DreKXN7d3w&s");
        xCompleto.setAtivo(true);
        produtoRepository.save(xCompleto);

        Produto batataFrita = new Produto();
        batataFrita.setNome("Batata Frita");
        batataFrita.setDescricao("Porção de batatas fritas crocantes");
        batataFrita.setCategoria("Acompanhamentos");
        batataFrita.setPreco(12.00);
        batataFrita.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRaYL47nsINFosC393PEQOoWuPAQvcX3Csbcg&s");
        batataFrita.setAtivo(true);
        produtoRepository.save(batataFrita);

        Produto onionRings = new Produto();
        onionRings.setNome("Onion Rings");
        onionRings.setDescricao("Anéis de cebola empanados e fritos");
        onionRings.setCategoria("Acompanhamentos");
        onionRings.setPreco(14.00);
        onionRings.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ43txN1E-Kchn5IS5x-dD0RLvbFqfQI_WY4A&s");
        onionRings.setAtivo(true);
        produtoRepository.save(onionRings);

        Produto nuggets = new Produto();
        nuggets.setNome("Nuggets de Frango");
        nuggets.setDescricao("6 unidades de nuggets de frango");
        nuggets.setCategoria("Acompanhamentos");
        nuggets.setPreco(13.00);
        nuggets.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSNe9muOE1Wfdu6A6VUgIGjSj6ESGarxWDyXw&s");
        nuggets.setAtivo(true);
        produtoRepository.save(nuggets);

        Produto sorvete = new Produto();
        sorvete.setNome("Sorvete de Chocolate");
        sorvete.setDescricao("Sorvete de chocolate com calda");
        sorvete.setCategoria("Sobremesas");
        sorvete.setPreco(8.50);
        sorvete.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTej0ofHMJpthYeFP0e5X3rcD3G92RSwA6Reg&s");
        sorvete.setAtivo(true);
        produtoRepository.save(sorvete);

        Produto milkshake = new Produto();
        milkshake.setNome("Milkshake de Morango");
        milkshake.setDescricao("Milkshake cremoso de morango");
        milkshake.setCategoria("Sobremesas");
        milkshake.setPreco(12.00);
        milkshake.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT16nvBuScLgbowz-4RUmRoPdkNfiNybRw_zw&s");
        milkshake.setAtivo(true);
        produtoRepository.save(milkshake);

        Produto brownie = new Produto();
        brownie.setNome("Brownie");
        brownie.setDescricao("Brownie de chocolate com sorvete");
        brownie.setCategoria("Sobremesas");
        brownie.setPreco(10.00);
        brownie.setImagem("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsjhDWNSGEV3zx3UPNi-gVWMcPF7KGmjdivg&s");
        brownie.setAtivo(true);
        produtoRepository.save(brownie);

        System.out.println("Dados de exemplo criados com sucesso!");
    }
} 