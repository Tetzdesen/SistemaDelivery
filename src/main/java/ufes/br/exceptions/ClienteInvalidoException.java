/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ufes.br.exceptions;

/**
 *
 * @author tetzner
 */
public class ClienteInvalidoException extends RuntimeException {
    public ClienteInvalidoException(String mensagem){
        super(mensagem);
    }
}
