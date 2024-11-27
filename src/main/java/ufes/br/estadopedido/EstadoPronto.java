package ufes.br.estadopedido;

import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public class EstadoPronto extends EstadoPedido {

    public EstadoPronto(Pedido pedido) {
        super(pedido);
        System.out.println("Pedido entregue. ");
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
        pedido.setEstadoPedido(new EstadoEntregue(pedido));
    }


}
