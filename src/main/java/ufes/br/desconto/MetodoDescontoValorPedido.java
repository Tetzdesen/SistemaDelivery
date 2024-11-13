package ufes.br.desconto;

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
    public void calcularDesconto(Pedido pedido) {
        
        if(seAplica(pedido)){         
            //if(pedido.getDescontoConcedido() < 10.00){ 
               pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por valor pedido", VALOR_DESCONTO));
            //}        
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return pedido.getValorPedido() > limiteValorPedido;
    }
    
}
