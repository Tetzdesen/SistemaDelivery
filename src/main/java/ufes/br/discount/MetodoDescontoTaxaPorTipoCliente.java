package ufes.br.discount;

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
    private String tipoCliente;
    private Map<String,Double> descontosPorTipoCliente = new HashMap<>();
    
    public MetodoDescontoTaxaPorTipoCliente(){
        descontosPorTipoCliente.put("Ouro", 3.00);
        descontosPorTipoCliente.put("Prata", 2.00);
        descontosPorTipoCliente.put("Bronze", 1.00);
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {

        tipoCliente = pedido.getCliente().getTipo();
        double valorDesconto;
        
        if(seAplica(pedido)){
            valorDesconto = descontosPorTipoCliente.get(pedido.getCliente().getTipo());
            if(pedido.getDescontoConcedido() + valorDesconto > 10.00){ 
                return new CupomDescontoEntrega("Desconto parcial por tipo de cliente", 10.00 - pedido.getDescontoConcedido()); 
            }  
            return new CupomDescontoEntrega("Desconto total por tipo de cliente", valorDesconto);
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return (tipoCliente.equals("Ouro") || tipoCliente.equals("Prata") || tipoCliente.equals("Bronze"));
    }
}
