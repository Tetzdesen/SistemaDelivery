package ufes.br.descontopedido;

import java.util.ArrayList;
import java.util.List;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public final class CalculadoraDescontoPedidoService {
    private final List<IMetodoDescontoPedido> metodosDeDescontoPedido;

    public CalculadoraDescontoPedidoService() {
        this.metodosDeDescontoPedido = new ArrayList<>();
        metodosDeDescontoPedido.add(new MetodoDescontoPedidoPorTipoCliente());
        metodosDeDescontoPedido.add(new MetodoDescontoPedidoPorCodigo());
        metodosDeDescontoPedido.add(new MetodoDescontoPedidoPorTipoItem());
    }
    
    public void calcularDescontoPedido(Pedido pedido){
        if(pedido == null){
            throw new IllegalArgumentException("Pedido invalido");
        }
        
        for(IMetodoDescontoPedido metodoDescontoPedido : metodosDeDescontoPedido){   
            metodoDescontoPedido.aplicarDesconto(pedido);      
        }  
    }
    
    public void adicionarMetodoDescontoPedido(IMetodoDescontoPedido metodoDescontoPedido){
        if(metodoDescontoPedido == null) throw new IllegalArgumentException("Metodo de desconto de pedido invalido");
        metodosDeDescontoPedido.add(metodoDescontoPedido);
    }
   
}
