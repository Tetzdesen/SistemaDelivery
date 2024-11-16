/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class DataPedidoInvalidaException extends RuntimeException{
    public DataPedidoInvalidaException(){
        super("Data do pedido inválida. ");
    }
}
