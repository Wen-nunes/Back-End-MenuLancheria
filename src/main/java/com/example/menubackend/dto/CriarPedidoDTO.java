package com.example.menubackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CriarPedidoDTO {
    private String clienteNome;
    private String clienteTelefone;
    private List<ItemPedidoDTO> itens;
} 