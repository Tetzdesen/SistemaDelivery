package ufes.br.estadopedido;

import ufes.br.interfaces.IMetodoProcessamento;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoAberto extends EstadoPedido implements IMetodoProcessamento {

    @Override
    public void preparar(Pedido pedido) {
        pedido.setEstadoPedido(new EstadoEmPreparo());
    }

    @Override
    public void finalizarPreparo(Pedido pedido) {
        throw new RuntimeException("Pedido nao comecou a ser preparado. ");
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new RuntimeException("Pedido ainda não finalizado ");
    }
    
}
