package ufes.br.desconto;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import ufes.br.interfaces.IMetodoDescontoTaxaEntrega;
import ufes.br.model.CupomDescontoEntrega;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */

public class MetodoDescontoPorDataPedido implements IMetodoDescontoTaxaEntrega {

    private final Map<LocalDate,Double> descontosPorData = new HashMap<>();
    
    public MetodoDescontoPorDataPedido(){   
        descontosPorData.put(LocalDate.of(2025, Month.JANUARY, 1), 1.00);
        descontosPorData.put(LocalDate.of(2024, Month.OCTOBER, 12), 1.50);
        descontosPorData.put(LocalDate.of(2024, Month.DECEMBER, 25), 2.00);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        if(seAplica(pedido)){
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto pela data do pedido", descontosPorData.get(LocalDate.now())));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
      LocalDate dataAtualPedido = pedido.getDataPedido();
      return descontosPorData.containsKey(dataAtualPedido);
    //  int mes = dataAtualPedido.getMonthValue();
      //int ano = dataAtualPedido.getYear();
      
      /*
      for (Map.Entry<LocalDate, Double> descontoData : descontosPorData.entrySet()) {
          LocalDate data = descontoData.getKey();
          return mes == descontosPorData.
      }*/

    }
    
}

