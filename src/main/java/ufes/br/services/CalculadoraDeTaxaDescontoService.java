package ufes.br.services;

import java.util.ArrayList;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;
import java.util.List;
import ufes.br.desconto.MetodoDescontoTaxaPorBairro;
import ufes.br.desconto.MetodoDescontoTaxaPorTipoCliente;
import ufes.br.desconto.MetodoDescontoTipoItem;
import ufes.br.desconto.MetodoDescontoValorPedido;

/**
 *
 * @author tetzner
 */
public class CalculadoraDeTaxaDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDeDesconto = new ArrayList<>();
    
    public CalculadoraDeTaxaDescontoService(){
        metodosDeDesconto.add(new MetodoDescontoTaxaPorBairro());
        metodosDeDesconto.add(new MetodoDescontoTipoItem());
        metodosDeDesconto.add(new MetodoDescontoTaxaPorTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoValorPedido(200.00)); 
    }
    
    public void calcularDescontoTaxa(Pedido pedido){
        for(IMetodoDescontoTaxaEntrega metodoDesconto : metodosDeDesconto){   
            metodoDesconto.calcularDesconto(pedido);
        }   
    }
    
    public void adicionarMetodoDesconto(IMetodoDescontoTaxaEntrega metodoDesconto){
        metodosDeDesconto.add(metodoDesconto);
    }
    
}