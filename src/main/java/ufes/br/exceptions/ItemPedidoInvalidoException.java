package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class ItemPedidoInvalidoException extends RuntimeException {
    public ItemPedidoInvalidoException(String mensagem){
        super(mensagem);
    }
}
