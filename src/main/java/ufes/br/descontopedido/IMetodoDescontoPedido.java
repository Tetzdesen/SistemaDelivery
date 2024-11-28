/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ufes.br.descontopedido;

import ufes.br.model.Pedido;

/**
 *
 * @author tetzner
 */
public interface IMetodoDescontoPedido {
    public void aplicarDesconto(Pedido pedido);
    public boolean seAplica(Pedido pedido);
}
