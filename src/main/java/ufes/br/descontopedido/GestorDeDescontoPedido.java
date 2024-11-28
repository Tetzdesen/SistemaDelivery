/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.descontopedido;

import java.util.ArrayList;
import java.util.List;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class GestorDeDescontoPedido {
    private final List<IMetodoDescontoPedido> descontosDePedido;

    public GestorDeDescontoPedido() {
        this.descontosDePedido = new ArrayList<>();
    }
    
    public void calcularTaxaDescontoPedido(Pedido pedido){
        if(descontosDePedido.isEmpty()){
          for(IMetodoDescontoPedido metodoDescontoPedido : descontosDePedido){   
            metodoDescontoPedido.aplicarDesconto(pedido);
        }  
        }
      
    }
    
    public void adicionarMetodo(IMetodoDescontoPedido metodoDescontoPedido){
        descontosDePedido.add(metodoDescontoPedido);
    }
    
    
    
}
