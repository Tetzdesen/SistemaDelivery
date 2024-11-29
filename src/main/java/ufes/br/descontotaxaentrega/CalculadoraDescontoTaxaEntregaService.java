package ufes.br.descontotaxaentrega;

import java.util.ArrayList;
import ufes.br.descontotaxaentrega.IMetodoDescontoTaxaEntrega;
import ufes.br.pedido.model.Pedido;
import java.util.List;
import ufes.br.descontotaxaentrega.IMetodoDescontoTaxaEntrega;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorDataPedido;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorDataPedido;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorBairro;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorBairro;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorTipoCliente;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorTipoCliente;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorTipoItem;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorTipoItem;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorValorPedido;
import ufes.br.descontotaxaentrega.MetodoDescontoTaxaEntregaPorValorPedido;

/**
 *
 * @author tetzner
 */
public class CalculadoraDescontoTaxaEntregaService {
    private final List<IMetodoDescontoTaxaEntrega> metodosDeDesconto;
    
    public CalculadoraDescontoTaxaEntregaService(){
        metodosDeDesconto = new ArrayList<>();
        metodosDeDesconto.add(new MetodoDescontoTaxaEntregaPorValorPedido(2000.00)); 
        metodosDeDesconto.add(new MetodoDescontoTaxaEntregaPorBairro());
        metodosDeDesconto.add(new MetodoDescontoTaxaEntregaPorTipoItem());
        metodosDeDesconto.add(new MetodoDescontoTaxaEntregaPorTipoCliente());
        metodosDeDesconto.add(new MetodoDescontoTaxaEntregaPorDataPedido()); 
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