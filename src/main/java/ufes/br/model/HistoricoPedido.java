/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.model;

import java.time.LocalDateTime;

/**
 *
 * @author tetzner
 */
public class HistoricoPedido {
    private EstadoPedido estadoPedido;
    private LocalDateTime horaDeMudanca;

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estadoPedido) {
        this.estadoPedido = estadoPedido;
    }

    public LocalDateTime getHoraDeMudanca() {
        return horaDeMudanca;
    }

    public void setHoraDeMudanca(LocalDateTime horaDeMudanca) {
        this.horaDeMudanca = horaDeMudanca;
    }
    
    
}
