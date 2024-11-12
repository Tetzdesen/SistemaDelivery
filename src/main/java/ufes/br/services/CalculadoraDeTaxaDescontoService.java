package ufes.br.services;

import java.util.ArrayList;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.Pedido;
import java.util.List;
import ufes.br.model.CupomDescontoEntrega;

/**
 *
 * @author tetzner
 */
public class CalculadoraDeTaxaDescontoService {
    private List<IMetodoDescontoTaxaEntrega> metodosDeDesconto = new ArrayList<>();
    
    public CalculadoraDeTaxaDescontoService(List<IMetodoDescontoTaxaEntrega> metodosDeDesconto){
       this.metodosDeDesconto = metodosDeDesconto; 
    }
    
    public void calcularDescontoTaxa(Pedido pedido){
        
        for(IMetodoDescontoTaxaEntrega metodoDesconto : metodosDeDesconto){   
      
            CupomDescontoEntrega desconto = metodoDesconto.calcularDesconto(pedido);
            
            pedido.aplicarDesconto(desconto);
            
            // logica para o limite de desconto
            if(pedido.getDescontoConcedido() > 10){
                break;
            }
        }   
    }
}