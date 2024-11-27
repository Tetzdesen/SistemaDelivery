package ufes.br.estadopedido;

import ufes.br.interfaces.IMetodoProcessamento;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoEntregue extends EstadoPedido implements IMetodoProcessamento{

    @Override
    public void preparar(Pedido pedido) {
       throw new RuntimeException("Pedido ja preparado. ");
    }

    @Override
    public void finalizarPreparo(Pedido pedido) {
       throw new RuntimeException("Pedido ja finalizado. ");
    }

    @Override
    public void entregar(Pedido pedido) {
       throw new RuntimeException("Pedido ja entregue. ");
    }
    
}
