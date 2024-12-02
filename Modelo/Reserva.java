/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Modelo;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agustín
 */

public class Reserva implements Serializable {
    @Serial
    private static final long serialVersionUID = 2L;
    private int idReserva;
    private String cliente;
    private List<Vehiculo> vehiculos;
    private double total;

    public Reserva(int idReserva, String cliente, double total) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.vehiculos = new ArrayList<>();
        this.total = total;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }
    
    public void calcularTotal(int dias) {
        total = vehiculos.stream().mapToDouble(v -> v.calcularCostoAlquiler(dias)).sum();
    }
    
    public String mostrarDetalle() {
        return "ID para la Reserva del Vehiculo: " + idReserva + "\nNombre del Cliente: " + cliente + "\nCosto Total de la Reserva: " + total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Reserva {");
        sb.append("id = ").append(idReserva);
        sb.append(", cliente = ").append(cliente);
        sb.append(", total =").append(total);
        sb.append("}");
        return sb.toString();
    }
}