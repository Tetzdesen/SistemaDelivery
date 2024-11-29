package ufes.br.pedido.model;

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
    private final List<Item> itens;
    private final List<CupomDescontoEntrega> cuponsDescontoEntrega;
    private final List<CupomDescontoPedido> cuponsDescontoPedido;
    
    public Pedido(double taxaEntrega, LocalDate dataPedido, Cliente cliente){
        // verificar valores de taxaEntrega, dataPedido e cliente, se não atenderem lançar exceção
        if(taxaEntrega < 0 || dataPedido == null || cliente == null){
            throw new IllegalArgumentException("Dados do pedido invalidos");
        }
        
        this.taxaEntrega = taxaEntrega;
        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.cuponsDescontoEntrega = new ArrayList<>();
        this.cuponsDescontoPedido = new ArrayList<>();
    }
    
    public void adicionarItem(Item item){
        if(item == null) throw new IllegalArgumentException("Item invalido"); 
        itens.add(item);
    }
    
    public double getValorPedido(){
        double valorPedido = itens.stream().mapToDouble(Item::getValorTotal).sum();
        System.out.println(getDescontoTaxaEntregaConcedido());
        return valorPedido + getDescontoTaxaEntregaConcedido();
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
      
    public void aplicarDescontoTaxaEntrega(CupomDescontoEntrega cupomDescontoEntrega){
        if(cupomDescontoEntrega == null) throw new IllegalArgumentException("Cupom de desconto de entrega invalido");  
        cuponsDescontoEntrega.add(cupomDescontoEntrega);
    }
    
    public void aplicarDescontoPedido(CupomDescontoPedido cupomDescontoPedido){
        if(cupomDescontoPedido == null) throw new IllegalArgumentException("Cupom de desconto de pedido invalido");  
        cuponsDescontoPedido.add(cupomDescontoPedido);
    }
    
    public double getDescontoTaxaEntregaConcedido(){
       double descontoTaxaEntregaConcedido = cuponsDescontoEntrega.stream().mapToDouble(CupomDescontoEntrega::getValorDesconto).sum();
       return Math.min((taxaEntrega - (taxaEntrega *  descontoTaxaEntregaConcedido)), taxaEntrega);
    }
    
    public double getDescontoPedidoConcedido(){
       double descontoPedidoConcedido = cuponsDescontoPedido.stream().mapToDouble(CupomDescontoPedido::getValorDesconto).sum();
       return Math.min(getValorPedido() - (getValorPedido() * descontoPedidoConcedido), getValorPedido());
    }
    
    public List<CupomDescontoEntrega> getCuponsDescontoEntrega(){
       return Collections.unmodifiableList(cuponsDescontoEntrega);
    }
    
    public List<CupomDescontoPedido> getCuponsDescontoPedido(){
       return Collections.unmodifiableList(cuponsDescontoPedido);
    }

    @Override
    public String toString() {
        return "Pedido{" + "taxaEntrega=" + taxaEntrega + ", dataPedido=" + dataPedido + ", cliente=" + cliente + ", itens=" + itens + ", cuponsDescontoEntrega=" + cuponsDescontoEntrega + ", cuponsDescontoPedido=" + cuponsDescontoPedido + '}';
    }

}
