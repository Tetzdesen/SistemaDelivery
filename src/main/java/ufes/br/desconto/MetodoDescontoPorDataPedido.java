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
        descontosPorData.put(LocalDate.of(2025, Month.JANUARY, 1), 0.10);
        descontosPorData.put(LocalDate.of(2024, Month.OCTOBER, 12), 0.15);
        descontosPorData.put(LocalDate.of(2024, Month.DECEMBER, 25), 0.20);
    }
    
    @Override
    public void calcularDesconto(Pedido pedido) {
        if(seAplica(pedido)){
            pedido.aplicarDesconto(new CupomDescontoEntrega("Desconto pela data do pedido", descontosPorData.get(pedido.getDataPedido())));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
      return descontosPorData.containsKey(pedido.getDataPedido());
    }
    
}

