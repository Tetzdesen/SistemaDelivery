package ufes.br.descontotaxaentrega;

import ufes.br.pedido.model.CupomDescontoEntrega;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public final class MetodoDescontoTaxaEntregaPorValorPedido implements IMetodoDescontoTaxaEntrega {
    private final double limiteValorPedido;
    private static final double VALOR_DESCONTO = 0.15;
    
    public MetodoDescontoTaxaEntregaPorValorPedido(double limiteValorPedido){
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
        return pedido.getValorPedido() > limiteValorPedido;
    }
 }
    
