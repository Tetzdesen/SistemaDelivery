package ufes.br.desconto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ufes.br.model.CupomDescontoEntrega;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Item;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoTipoItem implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorTipoItem = new HashMap<>();
    
    public MetodoDescontoTipoItem(){
        descontosPorTipoItem.put("Alimentação", 5.00);
        descontosPorTipoItem.put("Educação", 2.00);
        descontosPorTipoItem.put("Lazer", 1.50);
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        double valorDesconto = 0.0;
        List<Item> itens = pedido.getItens();
        
        if(seAplica(pedido)){
            for(Item item : itens){
                valorDesconto += descontosPorTipoItem.get(item.getTipo());
            }
            if(pedido.getDescontoConcedido() + valorDesconto > 10.00){ 
                return new CupomDescontoEntrega("Desconto parcial por tipo de item", 10.00 - pedido.getDescontoConcedido()); 
            }
            return new CupomDescontoEntrega("Desconto total por tipo de item", valorDesconto);
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        
        for(Item item: pedido.getItens()){
            if(item.getTipo().equals("Alimentação") || item.getTipo().equals("Educação") || item.getTipo().equals("Lazer")){   
                return true;
            }
        }
       
        return false;
    }
    
}
