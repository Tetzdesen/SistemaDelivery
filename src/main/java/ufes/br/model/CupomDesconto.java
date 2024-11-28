package ufes.br.model;

/**
 *
 * @author tetzner
 */
public abstract class CupomDesconto {
    protected final String nomeMetodo;
    protected final double valorDesconto;
    
    public CupomDesconto(String nomeMetodo, double valorDesconto){
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
