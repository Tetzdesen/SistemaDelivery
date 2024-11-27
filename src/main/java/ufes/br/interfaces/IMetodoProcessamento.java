package ufes.br.interfaces;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public interface IMetodoProcessamento {
    
    public void preparar(Pedido pedido);
    
    public void finalizarPreparo(Pedido pedido);
    
    public void entregar(Pedido pedido);
}
