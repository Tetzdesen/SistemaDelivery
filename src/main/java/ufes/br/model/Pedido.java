/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tetzner
 */
public class Pedido {
    private double taxaEntrega = 10.00;
    private LocalDate dataPedido;
    private Cliente cliente;
    private List<Item> itens = new ArrayList<>();
    private List<CupomDescontoEntrega> cuponsDescontoEntrega = new ArrayList<>();
    
    public Pedido(LocalDate dataPedido, Cliente cliente){
        this.dataPedido = dataPedido;
        this.cliente = cliente;
    }
    
    public void adicionarItem(Item item){
        itens.add(item);
    }
    
    public double getValorPedido(){
        double valorPedido = 0.0;
        
        for(Item item : itens){
            valorPedido += item.getValorTotal();
        }
        
        return valorPedido;
    } 
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Item> getItens(){
        return itens;
    }
    
    public double getTaxaEntrega(){
        return taxaEntrega;
    }
    
    public LocalDate getDataPedido(){
        return dataPedido;
    }
    
    public void aplicarDesconto(CupomDescontoEntrega desconto){
        cuponsDescontoEntrega.add(desconto);
    }

    public double getDescontoConcedido(){
        double descontoConcedido = 0.0;
        
        for(CupomDescontoEntrega cupomDescontoEntrega: cuponsDescontoEntrega){
            if(cupomDescontoEntrega != null){
                descontoConcedido += cupomDescontoEntrega.getValorDesconto();
            }
        }
        return descontoConcedido;
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
        return cuponsDescontoEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", cliente=" + cliente + ", itens=" + itens + ", cuponsDescontoEntrega=" + cuponsDescontoEntrega + '}';
    }
}
