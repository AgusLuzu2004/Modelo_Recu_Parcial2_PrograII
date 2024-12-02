/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Excepciones;

/**
 *
 * @author Agustín
 */

public class InvalidVehiculoDataException extends RuntimeException {

    public InvalidVehiculoDataException(String message) {
        super(message);
    }
}