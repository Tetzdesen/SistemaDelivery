package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class PedidoInvalidoException extends RuntimeException {
    public PedidoInvalidoException(String mensagem){
        super(mensagem);
    }
}
