package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class ClienteInvalidoException extends RuntimeException {
    public ClienteInvalidoException(String mensagem){
        super(mensagem);
    }
}
