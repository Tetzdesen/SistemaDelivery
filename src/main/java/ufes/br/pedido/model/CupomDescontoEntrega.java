package ufes.br.pedido.model;

/**
 *
 * @author tetzner
 */
public final class CupomDescontoEntrega {
    private final String nomeMetodo;
    private final double valorDesconto;
    
    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto){
        if(nomeMetodo == null || valorDesconto < 0.0){
            throw new IllegalArgumentException("Dados do cupom de desconto entrega invalidos");
        }
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
