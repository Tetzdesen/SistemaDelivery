package ufes.br.descontopedido;

import java.util.HashMap;
import java.util.Map;
import ufes.br.pedido.model.CupomDescontoPedido;
import ufes.br.pedido.model.Pedido;

/**
 *
 * @author tetzner
 */
public final class MetodoDescontoPedidoPorCodigo implements IMetodoDescontoPedido {
    private final Map<String, Double> codigosDeDesconto;
    
    public MetodoDescontoPedidoPorCodigo(){
        codigosDeDesconto = new HashMap<>();
        codigosDeDesconto.put("DESC10", 0.10);
        codigosDeDesconto.put("DESC20", 0.20);
        codigosDeDesconto.put("DESC30", 0.30);
    }
    
    @Override
    public void aplicarDesconto(Pedido pedido) {  
        double desconto;
        if(seAplica(pedido)){
            desconto = codigosDeDesconto.get(pedido.getCodigoDeCupom());
            pedido.aplicarDescontoPedido(new CupomDescontoPedido("Desconto no pedido pelo codigo de cupom", desconto));
        }
    }

    @Override
    public boolean seAplica(Pedido pedido) {
        boolean ehAplicavel = false;
        for(CupomDescontoPedido cupomDescontoPedido : pedido.getCuponsDescontoPedido()){
            ehAplicavel = cupomDescontoPedido.getNomeMetodo().equals("Desconto no pedido pelo tipo de item");
        }
        return !ehAplicavel && codigosDeDesconto.containsKey(pedido.getCodigoDeCupom());
    }
    
}
