/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import Excepciones.*;
import java.io.Serial;
import java.io.Serializable;

/**
 *
 * @author Agustín
 */

public abstract class Vehiculo implements Serializable {
    @Serial
    protected static final long serialVersionUID = 1L;
    protected static int contadorId = 1;
    protected int id;
    protected String modelo;
    protected double precioBasePorDia;

    public Vehiculo(String modelo, double precioBasePorDia) {
        
        if (modelo.length() < 3) {
            throw new InvalidVehiculoDataException("El modelo debe tener al menos 3 caracteres.");
        }
        
        if (precioBasePorDia <= 0) {
            throw new InvalidVehiculoDataException("El precio base por dia tiene que ser mayor a 0.");
        }
        
        this.id = contadorId++;
        this.modelo = modelo;
        this.precioBasePorDia = precioBasePorDia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBasePorDia() {
        return precioBasePorDia;
    }

    public void setPrecioBasePorDia(double precioBasePorDia) {
        this.precioBasePorDia = precioBasePorDia;
    }
    
    public abstract double calcularCostoAlquiler(int dias);
    
    public String mostrarResumen() {
        return "Modelo del Vehiculo: " + modelo + "\nPrecio Base por Dia: $" + precioBasePorDia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Vehiculo {");
        sb.append("id = ").append(id);
        sb.append(", modelo = ").append(modelo);
        sb.append(", precio base por dia = ").append(precioBasePorDia);
        sb.append("}");
        return sb.toString();
    }
}