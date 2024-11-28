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
    private String codigoDeCupom;
    private final List<CupomDesconto> cuponsDescontoEntrega;
    private final List<CupomDesconto> cuponsDescontoPedido;
    private EstadoPedido estadoPedido;
    
    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente){
        // verificar valores de taxaEntrega, dataPedido e cliente, se não atenderem lançar exceção
        if(taxaEntrega < 0 || dataPedido == null || cliente == null){
            throw new IllegalArgumentException("Dados invalidos para criar um pedido. ");
        }
        
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cuponsDescontoEntrega = new ArrayList<>();
        this.cuponsDescontoPedido = new ArrayList<>();
        estadoPedido = new EstadoAberto(this);
    }

    public EstadoPedido getEstadoPedido() {
        return estadoPedido;
    }

    public void setEstadoPedido(EstadoPedido estado) {
        this.estadoPedido = estado;
    }
    
    public void adicionarItem(Item item){
        if(item == null) throw new IllegalArgumentException("Exceção: Item invalido. "); 
        itens.add(item);
    }
    
    public double getValorPedido(){
        double valorPedido = itens.stream().mapToDouble(Item::getValorTotal).sum();
        return (valorPedido - getDescontoPercentualConcedido()) + taxaEntrega;
    } 
    
    public Cliente getCliente(){
        return cliente;
    }

    public String getCodigoDeCupom() {
        return codigoDeCupom;
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
      
    public void aplicarDescontoTaxaEntrega(CupomDesconto cupomDesconto){
        if(cupomDesconto == null) throw new IllegalArgumentException("Exceção: Cupom Invalido. ");  
        cuponsDescontoEntrega.add(cupomDesconto);
    }
    
    public void aplicarDescontoPedido(CupomDesconto cupomDesconto){
        if(cupomDesconto == null) throw new IllegalArgumentException("Exceção: Cupom Invalido. ");  
        cuponsDescontoPedido.add(cupomDesconto);
    }


    public double getDescontoPercentualConcedido(){
       double descontoConcedido = cuponsDescontoEntrega.stream().mapToDouble(CupomDesconto::getValorDesconto).sum();
       return Math.min((taxaEntrega - (taxaEntrega *  descontoConcedido)), taxaEntrega);
    }
    
    public List<CupomDesconto> getCuponsDescontoEntrega(){
       return Collections.unmodifiableList(cuponsDescontoEntrega);
    }
    
    public List<CupomDesconto> getCuponsDescontoPedido(){
       return Collections.unmodifiableList(cuponsDescontoPedido);
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
