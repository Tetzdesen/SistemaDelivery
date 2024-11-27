package ufes.br.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ufes.br.estadopedido.EstadoAberto;

/**
 *
 * @author tetzner
 */
public class Pedido {
    private double taxaEntrega;
    private LocalDate dataPedido;
    private Cliente cliente;
    private final List<Item> itens;
    private final List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private EstadoPedido estadoPedido;
    
    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente){
        // verificar valores de taxaEntrega, dataPedido e cliente, se não atenderem lançar exceção
        if(taxaEntrega < 0){
            throw new IllegalArgumentException("Exceção - Taxa de entrega: " + taxaEntrega);
        }
        
        if(dataPedido == null){
            throw new IllegalArgumentException("Exceção - Data do pedido: " + dataPedido);
        }
        
        if(cliente == null){
             throw new IllegalArgumentException("Exceção - Cliente: " + cliente);
        }
        
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cuponsDescontoEntrega = new ArrayList<>();
        estadoPedido = new EstadoAberto(this);
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estado) {
        this.estadoPedido = estado;
    }
    
    public void adicionarItem(Item item){
        if(item == null) throw new IllegalArgumentException("Exceção - Item: " + item); 
        itens.add(item);
    }
    
    public double getValorPedido(){
        double valorPedido = itens.stream().mapToDouble(Item::getValorTotal).sum();
        return  valorPedido + getDescontoPercentualConcedido();
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
    
    public void aplicarDesconto(CupomDescontoEntrega cupomDesconto){
        if(cupomDesconto == null) throw new IllegalArgumentException("Exceção - Cupom de desconto entrega: " + cupomDesconto);  
        cuponsDescontoEntrega.add(cupomDesconto);
    }

    public double getDescontoPercentualConcedido(){
       double descontoConcedido = cuponsDescontoEntrega.stream().mapToDouble(CupomDescontoEntrega::getValorDesconto).sum();
       return Math.min((taxaEntrega - (taxaEntrega *  descontoConcedido)), taxaEntrega);
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
       return Collections.unmodifiableList(cuponsDescontoEntrega);
    }
    
    public void preparar(){
        estadoPedido.preparar();
    }
    
    public void finalizarPreparo(){
       estadoPedido.finalizarPreparo();
    }
    
    public void entregar(){
        estadoPedido.entregar();
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", dataPedido=" + dataPedido + ", cliente=" + cliente + ", itens=" + itens + ", cuponsDescontoEntrega=" + cuponsDescontoEntrega + ", estadoPedido=" + estadoPedido + '}';
    }

}
