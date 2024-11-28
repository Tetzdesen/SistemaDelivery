package ufes.br.descontotaxaentrega;

import java.util.HashMap;
import java.util.Map;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.CupomDescontoEntrega;
import ufes.br.model.Item;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoTipoItem implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorTipoItem;
    
    public MetodoDescontoTipoItem(){
        descontosPorTipoItem = new HashMap<>();
        descontosPorTipoItem.put("Alimentação", 0.05);
        descontosPorTipoItem.put("Educação", 0.20);
        descontosPorTipoItem.put("Lazer", 0.15);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        double valorDesconto = 0;
        
        if(seAplica(pedido)){
            for(Item item : pedido.getItens()){
               valorDesconto += descontosPorTipoItem.get(item.getTipo());
            }
            
            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por tipo de item ", valorDesconto, pedido.getTaxaEntrega())); 
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
