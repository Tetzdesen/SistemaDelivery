package ufes.br.interfaces;

import ufes.br.model.CupomDescontoEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public interface IMetodoDescontoTaxaEntrega {
    public CupomDescontoEntrega calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
