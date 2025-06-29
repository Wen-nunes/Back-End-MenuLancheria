package com.example.menubackend.repository;

import com.example.menubackend.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    List<Pedido> findByStatus(Pedido.StatusPedido status);
    
    List<Pedido> findByDataPedidoBetween(LocalDateTime inicio, LocalDateTime fim);
    
    List<Pedido> findByClienteTelefone(String telefone);
    
    List<Pedido> findByClienteNomeContainingIgnoreCase(String nome);
    
    List<Pedido> findByStatusOrderByDataPedidoAsc(Pedido.StatusPedido status);
    
    long countByStatus(Pedido.StatusPedido status);
} 