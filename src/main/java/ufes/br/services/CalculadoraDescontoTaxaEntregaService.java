package ufes.br.services;

import java.util.ArrayList;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;
import java.util.List;
import ufes.br.desconto.MetodoDescontoPorDataPedido;
import ufes.br.desconto.MetodoDescontoTaxaPorBairro;
import ufes.br.desconto.MetodoDescontoTaxaPorTipoCliente;
import ufes.br.desconto.MetodoDescontoTipoItem;
import ufes.br.desconto.MetodoDescontoValorPedido;

/**
 *
 * @author tetzner
 */
public class CalculadoraDescontoTaxaEntregaService {
    private final List<IMetodoDescontoTaxaEntrega> metodosDeDesconto;
    
    public CalculadoraDescontoTaxaEntregaService(){
        metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(new MetodoDescontoValorPedido(2000.00)); 
        metodosDeDesconto.add(new MetodoDescontoTaxaPorBairro());
        metodosDeDesconto.add(new MetodoDescontoTipoItem());
        metodosDeDesconto.add(new MetodoDescontoTaxaPorTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoPorDataPedido()); 
    }
    
    public void calcularTaxaDesconto(Pedido pedido){
        for(IMetodoDescontoTaxaEntrega metodoDesconto : metodosDeDesconto){   
            metodoDesconto.calcularDesconto(pedido);
        }   
    }
    
    public void adicionarMetodo(IMetodoDescontoTaxaEntrega metodoDesconto){
        metodosDeDesconto.add(metodoDesconto);
    }
    
}