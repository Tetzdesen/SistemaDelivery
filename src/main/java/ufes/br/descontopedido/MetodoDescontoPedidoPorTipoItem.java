package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.pedido.model.CupomDescontoPedido;
import ufes.br.pedido.model.Item;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public final class MetodoDescontoPedidoPorTipoItem implements IMetodoDescontoPedido {
    
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
                pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo tipo de item", valorDesconto, pedido.getValorTotalPedido()));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        boolean pedidoEhAplicavel = false, possuiCumpoDeCodigoOuTipo = false;
        
        for(Item item: pedido.getItens()){
            if(descontosPorTipoItem.containsKey(item.getTipo())){
                pedidoEhAplicavel = true;
            }
        }
        
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            possuiCumpoDeCodigoOuTipo = cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo codigo de cupom") || cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de cliente");
        }
        
        return !possuiCumpoDeCodigoOuTipo && pedidoEhAplicavel;
    }
    
}
