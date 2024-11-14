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
    private final Map<String,Double> descontosPorTipoCliente = new HashMap<>();
    
    public MetodoDescontoTaxaPorTipoCliente(){
        descontosPorTipoCliente.put("Ouro", 3.00);
        descontosPorTipoCliente.put("Prata", 2.00);
        descontosPorTipoCliente.put("Bronze", 1.00);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {

        String tipoCliente = pedido.getCliente().getTipo();
        double valorDesconto;
        
        if(seAplica(pedido)){
            valorDesconto = descontosPorTipoCliente.get(tipoCliente);
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por tipo de cliente", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        String tipoCliente = pedido.getCliente().getTipo();
        return descontosPorTipoCliente.containsKey(tipoCliente);
    }
}
