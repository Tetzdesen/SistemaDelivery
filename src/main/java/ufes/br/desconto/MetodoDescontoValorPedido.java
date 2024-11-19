package ufes.br.desconto;

import ufes.br.model.CupomDescontoEntrega;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class MetodoDescontoValorPedido implements IMetodoDescontoTaxaEntrega {
    private final double limiteValorPedido;
    private static final double VALOR_DESCONTO = 0.15;
    
    public MetodoDescontoValorPedido(double limiteValorPedido){
        this.limiteValorPedido = limiteValorPedido;
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) { 
        if(seAplica(pedido)){         
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto por valor pedido", VALOR_DESCONTO));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
             return (pedido.getValorPedido() - (pedido.getTaxaEntrega() - pedido.getDescontoPercentualConcedido()))  > limiteValorPedido;
            //return (pedido.getValorPedido() - pedido.getTaxaEntrega()) > limiteValorPedido;
    }
 }
    
