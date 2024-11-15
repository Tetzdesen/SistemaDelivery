package ufes.br.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author tetzner
 */
public class Pedido {
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private final List<Item> itens = new ArrayList<>();
    private final List<CupomDescontoEntrega> cuponsDescontoEntrega = new ArrayList<>();
    
    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente){
        // verificar valores de taxaEntrega, dataPedido e cliente, se não atenderem lançar exceção
        if(taxaEntrega < 0){
            throw new RuntimeException("Pedido não pode ser criado, taxa de entrega inválida. ");
        }
        
        if(dataPedido == null){
            throw new RuntimeException("Pedido não pode ser criado, data do pedido inválida. ");
        }
        
        if(cliente == null){
             throw new RuntimeException("Pedido não pode ser criado, cliente inválido. ");
        }
        
        this.taxaEntrega = taxaEntrega;
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
        
        return valorPedido + taxaEntrega;
    } 
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public List<Item> getItens(){
        return Collections.unmodifiableList(itens);
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
            descontoConcedido += cupomDescontoEntrega.getValorDesconto();
        }
        
        if((taxaEntrega * descontoConcedido) > taxaEntrega){
            return taxaEntrega;
        }
        
        return (taxaEntrega * descontoConcedido);
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
       return Collections.unmodifiableList(cuponsDescontoEntrega);
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", cliente=" + cliente + ", itens=" + itens + ", cuponsDescontoEntrega=" + cuponsDescontoEntrega + '}';
    }
}
