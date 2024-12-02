/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;

/**
 *
 * @author Agustín
 */

public class VehiculoAuto extends Vehiculo {
    private boolean esLujo;

    public VehiculoAuto(String modelo, double precioBasePorDia, boolean esLujo) {
        super(modelo, precioBasePorDia);
        this.esLujo = esLujo;
    }

    public boolean isEsLujo() {
        return esLujo;
    }

    public void setEsLujo(boolean esLujo) {
        this.esLujo = esLujo;
    }

    @Override
    public double calcularCostoAlquiler(int dias) {
        
        if (esLujo) {
            return getPrecioBasePorDia() * dias * 1.25;
        }
        else {
            return getPrecioBasePorDia() * dias;
        }
    }
}