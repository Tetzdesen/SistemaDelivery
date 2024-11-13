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
    private String bairroCliente;
    private Map<String, Double> descontosPorBairro = new HashMap<>();
    
    public MetodoDescontoTaxaPorBairro(){
        descontosPorBairro.put("Centro", 2.00);
        descontosPorBairro.put("Bela Vista", 3.00);
        descontosPorBairro.put("Cidade Maravilhosa", 1.50);
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        bairroCliente = pedido.getCliente().getBairro();
        double valorDesconto;

        if(seAplica(pedido)){
            valorDesconto = descontosPorBairro.get(pedido.getCliente().getBairro());
            if(pedido.getDescontoConcedido() + valorDesconto > 10.00){ 
                return new CupomDescontoEntrega("Desconto parcial por bairro", 10.00 - pedido.getDescontoConcedido()); 
            }
            
            return new CupomDescontoEntrega("Desconto total por bairro", valorDesconto);
        }
        return null; 
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return (bairroCliente.equals("Centro") || bairroCliente.equals("Bela Vista") || bairroCliente.equals("Cidade Maravilhosa"));
    }
    
}
