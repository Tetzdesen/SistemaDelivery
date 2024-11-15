package ufes.br.sistemadelivery;

import ufes.br.services.CalculadoraDescontoTaxaEntregaService;
import ufes.br.model.Pedido;
import ufes.br.model.Item;
import ufes.br.model.Cliente;
import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author tetzner
 */
public class Principal {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Gabriel Tetzner", "Ouro", 3.0, "...", "Guararema","Alegre");
     //   Pedido pedido = new Pedido(10.00, LocalDate.now(), cliente);
     Pedido pedido = new Pedido(10.00, LocalDate.of(2025, Month.JANUARY, 1), cliente);
      //  Item item1 = new Item("Lápis", 2, 1.00, "Educação");
       // Item item2 = new Item("Caneta", 5, 1.50, "Educação");
        Item item3 = new Item("X-Bacon", 1, 12.00, "Alimentação");
        Item item4 = new Item("X-Tudo", 1, 22.00, "Alimentação");
       //pedido.adicionarItem(item1);
       // pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);
        pedido.adicionarItem(item4);
     
        CalculadoraDescontoTaxaEntregaService calculadora = new CalculadoraDescontoTaxaEntregaService();
        
        calculadora.calcularTaxaDesconto(pedido);
        
        double valorDesconto = pedido.getDescontoConcedido();
      
        System.out.println(pedido);
        System.out.println("Desconto Concedido: " + valorDesconto);
    }   
}

