/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.pedido.model;

/**
 *
 * @author tetzner
 */
public class CupomDescontoEntrega {
    private final String nomeMetodo;
    private final double valorDesconto;
    private final double valorTaxaEntrega;
    
    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto, double valorTaxaEntrega){
        if(nomeMetodo == null || valorDesconto < 0.0 || valorTaxaEntrega < 0.0){
            throw new IllegalArgumentException("Dados do cupom de desconto entrega invalidos");
        }
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
        this.valorTaxaEntrega = valorTaxaEntrega;
    }
    
    public String getNomeMetodo(){
        return nomeMetodo;
    }
    
    public double getValorDesconto(){
        return valorDesconto;
    }

    public double getValorTaxaEntrega() {
        return valorTaxaEntrega;
    }  

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" + "nomeMetodo=" + nomeMetodo + ", valorDesconto=" + valorDesconto + ", valorTaxaEntrega=" + valorTaxaEntrega + '}';
    } 
    
}
