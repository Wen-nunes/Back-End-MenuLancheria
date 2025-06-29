package com.example.menubackend.service;

import com.example.menubackend.dto.*;
import com.example.menubackend.model.ItemPedido;
import com.example.menubackend.model.Pedido;
import com.example.menubackend.model.Produto;
import com.example.menubackend.repository.PedidoRepository;
import com.example.menubackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    // Converter Pedido para PedidoDTO
    private PedidoDTO toDTO(Pedido pedido) {
        List<ItemPedidoDTO> itensDTO = pedido.getItens().stream()
                .map(this::toItemDTO)
                .collect(Collectors.toList());

        return new PedidoDTO(
            pedido.getId(),
            pedido.getClienteNome(),
            pedido.getClienteTelefone(),
            pedido.getDataPedido(),
            pedido.getValorTotal(),
            pedido.getStatus(),
            itensDTO
        );
    }

    // Converter ItemPedido para ItemPedidoDTO
    private ItemPedidoDTO toItemDTO(ItemPedido item) {
        return new ItemPedidoDTO(
            item.getId(),
            item.getProduto().getId(),
            item.getProduto().getNome(),
            item.getQuantidade(),
            item.getPrecoUnitario(),
            item.getSubtotal()
        );
    }

    // Buscar todos os pedidos
    public List<PedidoDTO> findAll() {
        try {
            return pedidoRepository.findAll()
                    .stream()
                    .map(this::toDTO)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar pedidos: " + e.getMessage());
        }
    }

    // Buscar pedido por ID
    public Optional<PedidoDTO> findById(Long id) {
        return pedidoRepository.findById(id)
                .map(this::toDTO);
    }

    // Buscar pedidos por status
    public List<PedidoDTO> findByStatus(Pedido.StatusPedido status) {
        return pedidoRepository.findByStatus(status)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Buscar pedidos por telefone do cliente
    public List<PedidoDTO> findByTelefone(String telefone) {
        return pedidoRepository.findByClienteTelefone(telefone)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Criar novo pedido
    @Transactional
    public Optional<PedidoDTO> create(CriarPedidoDTO criarPedidoDTO) {
        try {
            Pedido pedido = new Pedido();
            pedido.setClienteNome(criarPedidoDTO.getClienteNome());
            pedido.setClienteTelefone(criarPedidoDTO.getClienteTelefone());
            pedido.setStatus(Pedido.StatusPedido.PENDENTE);

            // Calcular valor total primeiro
            double valorTotal = criarPedidoDTO.getItens().stream()
                    .mapToDouble(itemDTO -> {
                        Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                                .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.getProdutoId()));
                        return produto.getPreco() * itemDTO.getQuantidade();
                    })
                    .sum();
            
            pedido.setValorTotal(valorTotal);

            // Salva o pedido primeiro para garantir que ele tenha um ID
            final Pedido pedidoSalvo = pedidoRepository.save(pedido);

            // Agora crie os itens e associe ao pedido já salvo
            List<ItemPedido> itens = criarPedidoDTO.getItens().stream()
                .map(itemDTO -> {
                    Produto produto = produtoRepository.findById(itemDTO.getProdutoId())
                            .orElseThrow(() -> new RuntimeException("Produto não encontrado: " + itemDTO.getProdutoId()));
                    ItemPedido item = new ItemPedido();
                    item.setPedido(pedidoSalvo); // Use a variável final aqui
                    item.setProduto(produto);
                    item.setQuantidade(itemDTO.getQuantidade());
                    item.setPrecoUnitario(produto.getPreco());
                    item.calcularSubtotal();
                    return item;
                })
                .collect(Collectors.toList());

            pedidoSalvo.setItens(itens);

            // Salva novamente para garantir persistência dos itens
            Pedido pedidoFinal = pedidoRepository.save(pedidoSalvo);
            return Optional.of(toDTO(pedidoFinal));

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    // Atualizar status do pedido
    public Optional<PedidoDTO> updateStatus(Long id, Pedido.StatusPedido novoStatus) {
        return pedidoRepository.findById(id)
                .map(pedido -> {
                    pedido.setStatus(novoStatus);
                    return toDTO(pedidoRepository.save(pedido));
                });
    }

    // Deletar pedido
    public boolean delete(Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar estatísticas
    public long countByStatus(Pedido.StatusPedido status) {
        return pedidoRepository.countByStatus(status);
    }
} 