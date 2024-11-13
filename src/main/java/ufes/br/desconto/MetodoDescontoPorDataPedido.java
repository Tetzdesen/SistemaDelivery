package ufes.br.desconto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.CupomDescontoEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
/*
public class MetodoDescontoPorDataPedido implements IMetodoDescontoTaxaEntrega {

    private Map<LocalDate,Double> descontosPorData = new HashMap<>();
    
    public MetodoDescontoPorDataPedido(){
        
        descontosPorData.put(LocalDate.parse("01-01", DateTimeFormatter.ofPattern("dd-MM")), 1.00);
        descontosPorData.put(LocalDate.parse("12-10", DateTimeFormatter.ofPattern("dd-MM")), 2.00);
        descontosPorData.put(LocalDate.parse("25-12", DateTimeFormatter.ofPattern("dd-MM")), 2.50);
       // descontosPorData.put(LocalDate.parse("2024-01-01", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 1.00);  
        //descontosPorData.put(LocalDate.parse("2025-10-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2.00);
       // descontosPorData.put(LocalDate.parse("2024-12-25", DateTimeFormatter.ofPattern("yyyy-MM-dd")), 2.50);
      
    }
    
    @Override
    public CupomDescontoEntrega calcularDesconto(Pedido pedido) {
        if(seAplica(pedido)){
            return new CupomDescontoEntrega("Desconto pela data do pedido", descontosPorData.get(LocalDate.now()));
        }
        return null;
    }

    @Override
    public boolean seAplica(Pedido pedido) {
      return pedido.getDataPedido().isEqual(LocalDate.parse("2025-10-12", DateTimeFormatter.ofPattern("yyyy-MM-dd"))) || pedido.getDataPedido().isEqual(LocalDate.parse("2025-10-12", DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }
    
}
*/
