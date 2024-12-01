package ufes.br.pedido.model;

/**
 *
 * @author tetzner
 */
public final class Item {
    private final String nome;
    private final int quantidade;
    private final double valorUnitario;
    private final String tipo;
    
    public Item(String nome, int quantidade, double valorUnitario, String tipo){
        if(nome == null || quantidade < 0 || valorUnitario < 0.0 || tipo == null){
            throw new IllegalArgumentException("Dados do item invalidos");
        }
        this.nome = nome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.tipo = tipo;
    }
    
    public double getValorTotal(){
        return quantidade * valorUnitario;
    }
    
    public String getTipo(){
        return tipo;
    }

    @Override
    public String toString() {
        return "Item{" + "nome=" + nome + ", quantidade=" + quantidade + ", valorUnitario=" + valorUnitario + ", tipo=" + tipo + '}';
    }
}
