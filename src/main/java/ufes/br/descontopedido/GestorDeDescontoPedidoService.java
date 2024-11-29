/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.descontopedido;

import ufes.br.descontopedido.IMetodoDescontoPedido;
import java.util.ArrayList;
import java.util.List;
import ufes.br.descontopedido.MetodoDescontoPedidoPorCodigo;
import ufes.br.descontopedido.MetodoDescontoPedidoPorTipoCliente;
import ufes.br.descontopedido.MetodoDescontoPedidoPorTipoItem;
import ufes.br.pedido.model.CupomDescontoPedido;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public class GestorDeDescontoPedidoService {
    private final List<IMetodoDescontoPedido> descontosDePedido;

    public GestorDeDescontoPedidoService() {
        this.descontosDePedido = new ArrayList<>();
        descontosDePedido.add(new MetodoDescontoPedidoPorTipoCliente());
        descontosDePedido.add(new MetodoDescontoPedidoPorCodigo("DESC10"));
        descontosDePedido.add(new MetodoDescontoPedidoPorTipoItem());
    }
    
    public void calcularTaxaDescontoPedido(Pedido pedido){
   
        for(IMetodoDescontoPedido metodoDescontoPedido : descontosDePedido){   
            metodoDescontoPedido.aplicarDesconto(pedido);
            
        }  
    }
    
    public void adicionarMetodo(IMetodoDescontoPedido metodoDescontoPedido){
        if(metodoDescontoPedido == null) throw new IllegalArgumentException("Metodo de desconto de pedido invalido ");
        descontosDePedido.add(metodoDescontoPedido);
    }
    
    /*
    private boolean podeContinuarCalculando(Pedido pedido){
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            if((cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo codigo de cupom") || cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de cliente")) && cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de cliente") == false){
                return true;
            } else if((cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo codigo de cupom") == false && cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de cliente") == false) && cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de cliente") == true){
                return true;
            }
        }
        return false;
    }
    */
}
