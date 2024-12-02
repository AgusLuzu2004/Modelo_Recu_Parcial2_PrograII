/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Excepciones;

/**
 *
 * @author Agustín
 */

public class ReservaNotFoundException extends RuntimeException {

    public ReservaNotFoundException(String message) {
        super(message);
    }
}