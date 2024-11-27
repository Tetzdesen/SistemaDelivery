/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.services;
import ufes.br.estadopedido.EstadoAberto;
import ufes.br.model.EstadoPedido;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class ControladoraEstadoPedidoService {
    private EstadoPedido estadoPedido;

    public ControladoraEstadoPedidoService(Pedido pedido) {
       estadoPedido = new EstadoAberto(pedido);
    }

    public void preparar(){
        estadoPedido.preparar();
    }
    
    public void finalizarPreparo(){
       estadoPedido.finalizarPreparo();
    }
    
    public void entregar(){
        estadoPedido.entregar();
    }
}
