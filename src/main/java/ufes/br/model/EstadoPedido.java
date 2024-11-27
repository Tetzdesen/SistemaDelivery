/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.model;

import java.util.logging.Logger;
import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public abstract class EstadoPedido {
    
    protected Pedido pedido;
   // private static final Logger LOG = Logger.getLogger(EstadoPedido.class.getName());

    public EstadoPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public abstract void preparar();
    
    public abstract void finalizarPreparo();
    
    public abstract void entregar();
      
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}


