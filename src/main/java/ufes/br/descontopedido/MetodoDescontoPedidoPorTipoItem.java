/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.model.CupomDescontoPedido;
import ufes.br.model.Item;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoPedidoPorTipoItem implements IMetodoDescontoPedido {
    
    private final Map<String, Double> descontosPorTipoItem;
    
    public MetodoDescontoPedidoPorTipoItem(){
        descontosPorTipoItem = new HashMap<>();
        descontosPorTipoItem.put("Alimentação", 0.05);
        descontosPorTipoItem.put("Educação", 0.20);
        descontosPorTipoItem.put("Lazer", 0.15);
    }
            
    @Override
    public void aplicarDesconto(Pedido pedido) {
         double valorDesconto = 0.0;
        
        if(seAplica(pedido)){
            for(Item item : pedido.getItens()){
               valorDesconto += descontosPorTipoItem.get(item.getTipo());
            }
            
            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoPedido("Desconto no pedido por tipo de item ", valorDesconto, pedido.getValorPedido())); 
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        boolean isPedidoAplicavel = false;
        for(Item item: pedido.getItens()){
            isPedidoAplicavel = descontosPorTipoItem.containsKey(item.getTipo());   
        }
        return isPedidoAplicavel;
    }
    
}
