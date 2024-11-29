/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.pedido.model.CupomDescontoPedido;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoPedidoPorTipoCliente implements IMetodoDescontoPedido {

    private final Map<String,Double> descontosPorTipoCliente;
    
    public MetodoDescontoPedidoPorTipoCliente(){
        descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("Ouro", 0.30);
        descontosPorTipoCliente.put("Prata", 0.20);
        descontosPorTipoCliente.put("Bronze", 0.10);
    }
    
   @Override
    public void aplicarDesconto(Pedido pedido) {
        double valorDesconto;
        
        if(seAplica(pedido)){
            valorDesconto = descontosPorTipoCliente.get(pedido.getCliente().getTipo());
            if(podeAplicar(pedido) == false){
                pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo tipo de cliente", valorDesconto, pedido.getValorPedido()));
            }
      
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
    
    private boolean podeAplicar(Pedido pedido){
        boolean ehAplicavel = false;
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            ehAplicavel = cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de item");
        }
        return ehAplicavel;
    }
    
}
