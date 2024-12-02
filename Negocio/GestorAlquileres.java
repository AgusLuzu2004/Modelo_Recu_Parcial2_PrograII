/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Negocio;
import Modelo.*;
import Persistencia.*;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 * @author Agustín
 */

public class GestorAlquileres {
    private Repository<Vehiculo> vehiculoRepository;
    private Repository<Reserva> reservaRepository;

    public GestorAlquileres(String filePath) {
        this.vehiculoRepository = new VehiculoRepository(filePath);
        this.reservaRepository = new ReservaRepository(filePath);
    }

    public Repository<Vehiculo> getVehiculoRepository() {
        return vehiculoRepository;
    }

    public void setVehiculoRepository(Repository<Vehiculo> vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public Repository<Reserva> getReservaRepository() {
        return reservaRepository;
    }

    public void setReservaRepository(Repository<Reserva> reservaRepository) {
        this.reservaRepository = reservaRepository;
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculoRepository.add(vehiculo);
    }
    
    public Optional<Vehiculo> buscarVehiculoPorId(int id) {
        return vehiculoRepository.findById(id);
    }
    
    public void realizarReserva(Reserva reserva, int dias) {
        reserva.calcularTotal(dias);
        reservaRepository.add(reserva);
    }
    
    public double calcularIngresos() {
        return reservaRepository.findAll().stream().mapToDouble(r -> r.getTotal()).sum();
    }
    
    public List<Vehiculo> filtrarVehiculos(Predicate<Vehiculo> criterio) {
        return vehiculoRepository.findAll().stream().filter(criterio).toList();
    }
    
    public void aplicarDescuento(Function<Vehiculo, Double> descuento) {
        
        for (Vehiculo vehiculo : vehiculoRepository.findAll()) {
            double precioConDescuento = descuento.apply(vehiculo);
            System.out.println("Precio con descuento para " + vehiculo.getModelo() + ": $" + precioConDescuento);
        }
    }
}