/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.services;

import ufes.br.estadopedido.EstadoAberto;
import ufes.br.estadopedido.EstadoEmPreparo;
import ufes.br.estadopedido.EstadoEntregue;
import ufes.br.estadopedido.EstadoPronto;
import ufes.br.interfaces.IMetodoProcessamento;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class ControladoraMetodoProcessamentoService {
    private IMetodoProcessamento estadoPedido;
    
    public ControladoraMetodoProcessamentoService(){
        estadoPedido = new EstadoAberto();
    }
   
    public void preparar(Pedido pedido){
        estadoPedido.preparar(pedido);
        estadoPedido = new EstadoEmPreparo();
    }
    
    public void finalizarPreparo(Pedido pedido){
        estadoPedido.finalizarPreparo(pedido);
        estadoPedido = new EstadoPronto();
    }
    public void entregar(Pedido pedido){
        estadoPedido.entregar(pedido);
        estadoPedido = new EstadoEntregue();
    }
}
