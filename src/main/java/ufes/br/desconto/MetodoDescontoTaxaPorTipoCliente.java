package ufes.br.desconto;

import java.util.HashMap;
import java.util.Map;
import ufes.br.model.CupomDescontoEntrega;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoTaxaPorTipoCliente implements IMetodoDescontoTaxaEntrega {
   // private final Map<String,Double> descontosPorTipoCliente = new HashMap<>();
    private final Map<String,Double> descontosPorTipoCliente;
    public MetodoDescontoTaxaPorTipoCliente(){
        descontosPorTipoCliente = new HashMap<>();
        descontosPorTipoCliente.put("Ouro", 0.30);
        descontosPorTipoCliente.put("Prata", 0.20);
        descontosPorTipoCliente.put("Bronze", 0.10);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        double valorDesconto;
        
        if(seAplica(pedido)){
            valorDesconto = descontosPorTipoCliente.get(pedido.getCliente().getTipo());
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por tipo de cliente", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return descontosPorTipoCliente.containsKey(pedido.getCliente().getTipo());
    }
}
