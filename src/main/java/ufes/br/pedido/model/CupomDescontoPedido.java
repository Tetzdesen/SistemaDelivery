/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.pedido.model;

/**
 *
 * @author tetzner
 */
public final class CupomDescontoPedido{
    private final String nomeMetodo;
    private final double valorDesconto;
    private final double valorPedido;
    
    public CupomDescontoPedido(String nomeMetodo, double valorDesconto, double valorPedido){
         if(nomeMetodo == null || valorDesconto < 0.0 || valorPedido < 0.0){
            throw new IllegalArgumentException("Dados do cupom de desconto pedido invalidos");
        }
        this.nomeMetodo = nomeMetodo;
        this.valorDesconto = valorDesconto;
        this.valorPedido = valorPedido;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    @Override
    public String toString() {
        return "CupomDescontoPedido{" + "nomeMetodo=" + nomeMetodo + ", valorDesconto=" + valorDesconto + ", valorPedido=" + valorPedido + '}';
    }

    public double getValorPedido(){
        return valorPedido;
    }
}
