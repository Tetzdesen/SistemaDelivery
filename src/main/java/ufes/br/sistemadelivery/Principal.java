package ufes.br.sistemadelivery;

import ufes.br.descontotaxaentrega.CalculadoraDescontoTaxaEntregaService;
import ufes.br.pedido.model.Pedido;
import ufes.br.pedido.model.Item;
import ufes.br.pedido.model.Cliente;
import java.time.LocalDate;
import ufes.br.descontopedido.GestorDeDescontoPedidoService;

/**
 *
 * @author tetzner
 */
public class Principal {

    public static void main(String[] args) {
        
        Cliente cliente = new Cliente("Gabriel Tetzner", "Ouro", 3.0, "...", "Guararema","Alegre");
        
        Pedido pedido = new Pedido(10.00, LocalDate.now(), cliente);
        
        Item item1 = new Item("Lápis", 2, 1.00, "Educação");
        Item item2 = new Item("Caneta", 5, 1.50, "Educação");
        Item item3 = new Item("X-Bacon", 1, 12.00, "Alimentação");
        Item item4 = new Item("X-Tudo", 1, 22.00, "Alimentação");
        
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);
        pedido.adicionarItem(item4);
        
        CalculadoraDescontoTaxaEntregaService calculadora = new CalculadoraDescontoTaxaEntregaService();
        
        System.out.println("Valor do pedido atual: R$ " + pedido.getValorPedido());
        
        calculadora.calcularTaxaDesconto(pedido);
          System.out.println(pedido);
        double valorDesconto = pedido.getDescontoTaxaEntregaConcedido();

        System.out.println("Desconto na taxa de entrega concedida: R$ " + valorDesconto);
        
        System.out.println("Valor do pedido apos o calculo da taxa de entrega: R$ " + pedido.getValorPedido());
         
        GestorDeDescontoPedidoService gestorDesconto = new GestorDeDescontoPedidoService();
        
        gestorDesconto.calcularTaxaDescontoPedido(pedido);
        
        System.out.println("Desconto no pedido concedido: R$ " + pedido.getDescontoPedidoConcedido());
        
        System.out.println(pedido.getCuponsDescontoPedido());
        
        System.out.println("Valor do pedido apos o calculo de desconto baseado no pedido: R$ " + pedido.getValorPedido());
       
    }   
}

