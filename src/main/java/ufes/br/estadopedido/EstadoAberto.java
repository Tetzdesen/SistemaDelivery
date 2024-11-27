package ufes.br.estadopedido;

import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoAberto extends EstadoPedido {

    public EstadoAberto(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void preparar() {
        pedido.setEstadoPedido(new EstadoEmPreparo(pedido));
    }

    @Override
    public void finalizarPreparo() {
        throw new RuntimeException("Pedido nao comecou a ser preparado. ");
    }

    @Override
    public void entregar() {
        throw new RuntimeException("Pedido ainda não finalizado ");
    }
    
}
