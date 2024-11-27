package ufes.br.estadopedido;

import ufes.br.interfaces.IMetodoProcessamento;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoEmPreparo extends EstadoPedido implements IMetodoProcessamento {

    @Override
    public void preparar(Pedido pedido) {
        throw new RuntimeException("Pedido ja em preparacao. "); 
    }

    @Override
    public void finalizarPreparo(Pedido pedido) {
       pedido.setEstadoPedido(new EstadoPronto());
    }

    @Override
    public void entregar(Pedido pedido) {
        throw new RuntimeException("Pedido ainda nao finalizado. ");
    }
    
}
