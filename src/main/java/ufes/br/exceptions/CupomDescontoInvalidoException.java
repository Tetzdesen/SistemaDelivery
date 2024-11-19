package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class CupomDescontoInvalidoException extends RuntimeException {
    public CupomDescontoInvalidoException(String mensagem){
        super(mensagem);
    }
}
