package ufes.br.estadopedido;

import ufes.br.model.EstadoPedido;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoEmPreparo extends EstadoPedido {

    public EstadoEmPreparo(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void preparar() {
        throw new RuntimeException("Pedido ja em preparacao. "); 
    }

    @Override
    public void finalizarPreparo() {
       pedido.setEstadoPedido(new EstadoPronto(pedido));
    }

    @Override
    public void entregar() {
        throw new RuntimeException("Pedido ainda nao finalizado. ");
    }
    
}
