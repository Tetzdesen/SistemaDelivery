/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.model;

/**
 *
 * @author tetzner
 */
public class CupomDescontoEntrega extends CupomDesconto {
    private final double valorTaxaEntrega;
    
    public CupomDescontoEntrega(String nomeMetodo, double valorDesconto, double valorTaxaEntrega) {
        super(nomeMetodo, valorDesconto);
        this.valorTaxaEntrega = valorTaxaEntrega;      
    }

    public double getValorTaxaEntrega() {
        return valorTaxaEntrega;
    }  

    @Override
    public String toString() {
        return "CupomDescontoEntrega{" + "valorTaxaEntrega=" + valorTaxaEntrega + '}';
    }
    
    
    
}
