package ufes.br.descontotaxaentrega;

import ufes.br.model.CupomDesconto;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.CupomDescontoEntrega;
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
            pedido.aplicarDescontoTaxaEntrega(new CupomDescontoEntrega("Desconto por valor pedido", VALOR_DESCONTO, pedido.getTaxaEntrega()));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        return (pedido.getValorPedido() - pedido.getDescontoPercentualConcedido()) > limiteValorPedido;
            //return (pedido.getValorPedido() - pedido.getTaxaEntrega()) > limiteValorPedido;
    }
 }
    