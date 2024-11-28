/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.model;

/**
 *
 * @author tetzner
 */
public class CupomDescontoPedido extends CupomDesconto {
    private final double valorPedido;
    
    public CupomDescontoPedido(String nomeMetodo, double valorDesconto, double valorPedido){
        super(nomeMetodo, valorDesconto);
        this.valorPedido = valorPedido;
    }
    
    public double getValorPedido(){
        return valorPedido;
    }
}
