package ufes.br.sistemapedidos;

import ufes.br.services.CalculadoraDeTaxaDescontoService;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;
import ufes.br.model.Item;
import ufes.br.model.Cliente;
import ufes.br.discount.MetodoDescontoTipoItem;
import ufes.br.discount.MetodoDescontoTaxaPorBairro;
import ufes.br.discount.MetodoDescontoValorPedido;
import ufes.br.discount.MetodoDescontoTaxaPorTipoCliente;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tetzner
 */
public class Principal {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Gabriel Tetzner", "Ouro", 3.0, "...", "Cidade Maravilhosa","Guaçui");
        Pedido pedido = new Pedido(LocalDate.now(), cliente);
        Item item1 = new Item("Lápis", 2, 1.00, "Educação");
        Item item2 = new Item("Caneta", 5, 1.50, "Educação");
        
        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
       
        List<IMetodoDescontoTaxaEntrega> metodosDescontos = new ArrayList<>();
        metodosDescontos.add(new MetodoDescontoTaxaPorBairro());
        metodosDescontos.add(new MetodoDescontoTaxaPorTipoCliente());
        metodosDescontos.add(new MetodoDescontoTipoItem());
        metodosDescontos.add(new MetodoDescontoValorPedido(200.00)); 
        
        CalculadoraDeTaxaDescontoService calculadora = new CalculadoraDeTaxaDescontoService(metodosDescontos);
        
        calculadora.calcularDescontoTaxa(pedido);
        
        double valorDesconto = pedido.getDescontoConcedido();
        
        if(valorDesconto > 0){
            System.out.println("Desconto Concedido: " + valorDesconto);
        } 
        
    }
}
