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
    public void calcularDesconto(Pedido pedido) {
        double valorDesconto = 0.0;
        List<Item> itens = pedido.getItens();
        
        if(seAplica(pedido)){
            for(Item item : itens){
                valorDesconto += descontosPorTipoItem.get(item.getTipo());
            }
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por tipo de item", valorDesconto)); 
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        
        for(Item item: pedido.getItens()){
            descontosPorTipoItem.containsKey(item.getTipo());   
        }
       
        return false;
    }
    
}
