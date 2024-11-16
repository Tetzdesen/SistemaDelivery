/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class ItemInvalidoException extends RuntimeException {
    public ItemInvalidoException(){
        super("Item de pedido inválido, um item deve existir. ");
    }
}
