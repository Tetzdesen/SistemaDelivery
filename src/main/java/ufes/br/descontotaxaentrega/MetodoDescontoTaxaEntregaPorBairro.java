package ufes.br.descontotaxaentrega;

import java.util.HashMap;
import java.util.Map;
import ufes.br.pedido.model.CupomDescontoEntrega;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public final class MetodoDescontoTaxaEntregaPorBairro implements IMetodoDescontoTaxaEntrega {
    private final Map<String, Double> descontosPorBairro;
    public MetodoDescontoTaxaEntregaPorBairro(){
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
            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por bairro", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return descontosPorBairro.containsKey(pedido.getCliente().getBairro());
    }
    
}
