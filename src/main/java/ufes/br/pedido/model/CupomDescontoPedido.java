package ufes.br.pedido.model;

/**
 *
 * @author tetzner
 */
public final class CupomDescontoPedido{
    private final String nomeMetodo;
    private final double valorDesconto;
    
    public CupomDescontoPedido(String nomeMetodo, double valorDesconto){
         if(nomeMetodo == null || valorDesconto < 0.0){
            throw new IllegalArgumentException("Dados do cupom de desconto pedido invalidos");
        }
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "CupomDescontoPedido{" + "nomeMetodo=" + nomeMetodo + ", valorDesconto=" + valorDesconto + '}';
    }
   
}
