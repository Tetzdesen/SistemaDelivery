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
public class MetodoDescontoPedidoPorCodigo implements IMetodoDescontoPedido {
    private final Map<String, Double> codigosDeDesconto;
    private final String codigoDeCupom;
    
    public MetodoDescontoPedidoPorCodigo(String codigoCupom){
        codigosDeDesconto = new HashMap<>();
        codigosDeDesconto.put("DESC10", 0.10);
        codigosDeDesconto.put("DESC20", 0.20);
        codigosDeDesconto.put("DESC30", 0.30);
        this.codigoDeCupom = codigoCupom;
    }
    
    @Override
    public void aplicarDesconto(Pedido pedido) {  
        double desconto;
        if(seAplica(pedido)){
            desconto = codigosDeDesconto.get(codigoDeCupom);
            if(podeAplicar(pedido) == false){
               pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo codigo de cupom", desconto, pedido.getValorPedido()));
            }
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return codigosDeDesconto.containsKey(codigoDeCupom);
    }
    
    private boolean podeAplicar(Pedido pedido){
        boolean ehAplicavel = false;
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            ehAplicavel = cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de item");
        }
        return ehAplicavel;
    }
    
}
