package ufes.br.model;

/**
 *
 * @author tetzner
 */
public final class CupomDescontoEntrega {
    private final String nomeMetodo;
    private final double valorDesconto;
    
    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto){
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
    }
    
    public String getNomeMetodo(){
        return nomeMetodo;
    }
    
    public double getValorDesconto(){
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" + "nomeMetodo=" + nomeMetodo + ", valorDesconto=" + valorDesconto + '}';
    }
    
}
