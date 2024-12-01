package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.pedido.model.CupomDescontoPedido;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public final class MetodoDescontoPedidoPorTipoCliente implements IMetodoDescontoPedido {

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
            pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo tipo de cliente", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        boolean possuiCupomItem = false;
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            possuiCupomItem = cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de item");
        }
        return !possuiCupomItem && descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
    
}
