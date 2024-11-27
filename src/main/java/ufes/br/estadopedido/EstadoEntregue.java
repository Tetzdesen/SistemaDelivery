package ufes.br.estadopedido;

import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoEntregue extends EstadoPedido{

    public EstadoEntregue(Pedido pedido) {
        super(pedido);
    }

    @Override
    public void preparar() {
       throw new RuntimeException("Pedido ja preparado. ");
    }

    @Override
    public void finalizarPreparo() {
       throw new RuntimeException("Pedido ja finalizado. ");
    }

    @Override
    public void entregar() {
       throw new RuntimeException("Pedido ja entregue. ");
    }
    
}
