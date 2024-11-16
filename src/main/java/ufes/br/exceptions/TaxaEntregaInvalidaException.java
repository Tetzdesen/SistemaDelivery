/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class TaxaEntregaInvalidaException extends RuntimeException {
    public TaxaEntregaInvalidaException(){
        super("Taxa de entrega inválida, ela deve ser maior que 0. ");
    }
}
