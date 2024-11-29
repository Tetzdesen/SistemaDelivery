/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.pedido.model.CupomDescontoEntrega;
import ufes.br.pedido.model.CupomDescontoPedido;
import ufes.br.pedido.model.Item;
import ufes.br.pedido.model.Pedido;

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
            if(podeAplicar(pedido) == false){
                pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo tipo de item", valorDesconto, pedido.getValorPedido()));
            }
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
    
    private boolean podeAplicar(Pedido pedido){
        boolean ehAplicavel = false;
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            ehAplicavel = cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo codigo de cupom") || cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de cliente");
        }
        return ehAplicavel;
    }
    
}
