/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 *
 * @author Agustín
 */

public class VehiculoMoto extends Vehiculo {
    private int cilindrada;

    public VehiculoMoto(String modelo, double precioBasePorDia, int cilindrada) {
        super(modelo, precioBasePorDia);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        
        if (cilindrada > 500) {
            return getPrecioBasePorDia() * dias * 1.15;
        }
        else {
            return getPrecioBasePorDia() * dias;
        }
    }
}