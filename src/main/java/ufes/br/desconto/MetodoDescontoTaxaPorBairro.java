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
public class MetodoDescontoTaxaPorBairro implements IMetodoDescontoTaxaEntrega {
    private Map<String, Double> descontosPorBairro = new HashMap<>();
    
    public MetodoDescontoTaxaPorBairro(){
        descontosPorBairro.put("Centro", 2.00);
        descontosPorBairro.put("Bela Vista", 3.00);
        descontosPorBairro.put("Cidade Maravilhosa", 1.50);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        String bairroCliente = pedido.getCliente().getBairro();
        double valorDesconto;

        if(seAplica(pedido)){
            valorDesconto = descontosPorBairro.get(bairroCliente);
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por bairro", valorDesconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        String bairroCliente = pedido.getCliente().getBairro();
        return descontosPorBairro.containsKey(bairroCliente);
    }
    
}
