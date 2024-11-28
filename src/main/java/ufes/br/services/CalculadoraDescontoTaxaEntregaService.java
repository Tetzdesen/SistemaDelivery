package ufes.br.services;

import java.util.ArrayList;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;
import java.util.List;
import ufes.br.descontotaxaentrega.MetodoDescontoPorDataPedido;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaPorBairro;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaPorTipoCliente;
import ufes.br.descontotaxaentrega.MetodoDescontoTipoItem;
import ufes.br.descontotaxaentrega.MetodoDescontoValorPedido;

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