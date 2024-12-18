package ufes.br.descontotaxaentrega;

import java.util.ArrayList;
import ufes.br.pedido.model.Pedido;
import java.util.List;

/**
 *
 * @author tetzner
 */
public final class CalculadoraDescontoTaxaEntregaService {
    private final List<IMetodoDescontoTaxaEntrega> metodosDeDescontoTaxaEntrega;
    
    public CalculadoraDescontoTaxaEntregaService(){
        metodosDeDescontoTaxaEntrega = new ArrayList<>();
        metodosDeDescontoTaxaEntrega.add(new MetodoDescontoTaxaEntregaPorValorPedido(2000.00)); 
        metodosDeDescontoTaxaEntrega.add(new MetodoDescontoTaxaEntregaPorBairro());
        metodosDeDescontoTaxaEntrega.add(new MetodoDescontoTaxaEntregaPorTipoItem());
        metodosDeDescontoTaxaEntrega.add(new MetodoDescontoTaxaEntregaPorTipoCliente());
        metodosDeDescontoTaxaEntrega.add(new MetodoDescontoTaxaEntregaPorDataPedido()); 
    }
    
    public void calcularDescontoTaxaEntrega(Pedido pedido){
        if(pedido == null){
            throw new IllegalArgumentException("Pedido invalido");
        }
        for(IMetodoDescontoTaxaEntrega metodoDescontoTaxaEntrega : metodosDeDescontoTaxaEntrega){   
            metodoDescontoTaxaEntrega.calcularDesconto(pedido);
        }   
    }
    
    public void adicionarMetodoDescontoTaxaEntrega(IMetodoDescontoTaxaEntrega metodoDescontoTaxaEntrega){
        if(metodoDescontoTaxaEntrega == null){
            throw new IllegalArgumentException("Metodo de desconto de taxa de entrega invalida");
        }
        metodosDeDescontoTaxaEntrega.add(metodoDescontoTaxaEntrega);
    }
    
}