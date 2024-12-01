package ufes.br.sistemadelivery;

import ufes.br.descontotaxaentrega.CalculadoraDescontoTaxaEntregaService;
import ufes.br.pedido.model.Pedido;
import ufes.br.pedido.model.Item;
import ufes.br.pedido.model.Cliente;
import java.time.LocalDate;
import ufes.br.descontopedido.CalculadoraDescontoPedidoService;

/**
 *
 * @author tetzner
 */
public class Principal {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("Gabriel Tetzner", "Ouro", 2.0, "", "Guararema","Alegre");
        
        Pedido pedido = new Pedido(10.00, LocalDate.now(), cliente, "DESC10");
        
        Item item1 = new Item("Lápis", 2, 1.00, "Educação");
        Item item2 = new Item("Caneta", 5, 1.50, "Educação");
        Item item3 = new Item("X-Bacon", 1, 12.00, "Alimentação");
        Item item4 = new Item("X-Tudo", 1, 22.00, "Alimentação");
        
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);
        pedido.adicionarItem(item4);
        
        CalculadoraDescontoTaxaEntregaService calculadora = new CalculadoraDescontoTaxaEntregaService();
        
        System.out.println("Valor do pedido atual com a taxa de entrega: R$ " + pedido.getValorTotalPedido());
        
        calculadora.calcularDescontoTaxaEntrega(pedido);
        
        double valorDesconto = pedido.getDescontoTaxaEntregaConcedido();

        System.out.println("\nTaxa de entrega apos o desconto: R$ " + valorDesconto);
        
        System.out.println("\nValor do pedido apos o desconto na taxa de entrega: R$ " + pedido.getValorTotalPedido());
         
        CalculadoraDescontoPedidoService gestorDesconto = new CalculadoraDescontoPedidoService();
        
        gestorDesconto.calcularDescontoPedido(pedido);
        
        System.out.println("\nValor do pedido apos o desconto por valor de pedido: R$ " + pedido.getDescontoPedidoConcedido());
        
        System.out.println(pedido);
        
        System.out.println(pedido.getCuponsDescontoPedido());
        
        System.out.println("\nValor do pedido com desconto (taxa de entrega somada): R$ " + pedido.getValorTotalPedido());
       
    }   
}

