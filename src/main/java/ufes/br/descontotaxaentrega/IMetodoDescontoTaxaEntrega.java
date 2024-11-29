package ufes.br.descontotaxaentrega;

import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public interface IMetodoDescontoTaxaEntrega {
    public void calcularDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
