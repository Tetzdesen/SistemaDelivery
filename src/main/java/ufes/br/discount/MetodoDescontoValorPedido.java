package ufes.br.discount;

import ufes.br.model.CupomDescontoEntrega;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    private double limiteValorPedido;
    private static double VALOR_DESCONTO = 5.00;
    
    public MetodoDescontoValorPedido(double limiteValorPedido){
        this.limiteValorPedido = limiteValorPedido;
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        
        if(seAplica(pedido)){
            
            if(pedido.getDescontoConcedido() > 10.00){ 
                return new CupomDescontoEntrega("Desconto parcial por valor de pedido", 10.00 - pedido.getDescontoConcedido()); 
            }
            
            return new CupomDescontoEntrega("Desconto total por valor pedido", VALOR_DESCONTO);
            
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getValorPedido() > limiteValorPedido;
    }
    
}
