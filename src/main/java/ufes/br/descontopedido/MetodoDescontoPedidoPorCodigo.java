/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.model.CupomDescontoPedido;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoPedidoPorCodigo implements IMetodoDescontoPedido {
    private Map<String, Double> codigosDeDesconto;
    
    public MetodoDescontoPedidoPorCodigo(){
        codigosDeDesconto = new HashMap<>();
        codigosDeDesconto.put("DESC10", 0.10);
        codigosDeDesconto.put("DESC20", 0.20);
        codigosDeDesconto.put("DESC30", 0.30);
    }
    
    @Override
    public void aplicarDesconto(Pedido pedido) {  
        double desconto;
        if(seAplica(pedido)){
            desconto = codigosDeDesconto.get(pedido.getCodigoDeCupom());
            pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo código de cupom", desconto, pedido.getValorPedido()));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return codigosDeDesconto.containsKey(pedido.getCodigoDeCupom());
    }
    
}
