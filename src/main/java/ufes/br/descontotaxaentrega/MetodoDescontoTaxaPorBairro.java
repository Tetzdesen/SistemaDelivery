package ufes.br.descontotaxaentrega;

import java.util.HashMap;
import java.util.Map;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.CupomDescontoEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoTaxaPorBairro implements IMetodoDescontoTaxaEntrega {
    private final Map<String, Double> descontosPorBairro;
    public MetodoDescontoTaxaPorBairro(){
        this.descontosPorBairro = new HashMap<>();
        descontosPorBairro.put("Centro", 0.20);
        descontosPorBairro.put("Bela Vista", 0.30);
        descontosPorBairro.put("Cidade Maravilhosa", 0.15);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        double valorDesconto;
        if(seAplica(pedido)){
            valorDesconto = descontosPorBairro.get(pedido.getCliente().getBairro());
            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por bairro", valorDesconto, pedido.getTaxaEntrega()));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return descontosPorBairro.containsKey(pedido.getCliente().getBairro());
    }
    
}
