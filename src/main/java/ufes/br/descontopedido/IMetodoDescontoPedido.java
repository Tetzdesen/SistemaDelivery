package ufes.br.descontopedido;

import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public interface IMetodoDescontoPedido {
    public void aplicarDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
