package com.example.menubackend.dto;

import com.example.menubackend.model.Pedido;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private String clienteNome;
    private String clienteTelefone;
    private LocalDateTime dataPedido;
    private Double valorTotal;
    private Pedido.StatusPedido status;
    private List<ItemPedidoDTO> itens;
} 