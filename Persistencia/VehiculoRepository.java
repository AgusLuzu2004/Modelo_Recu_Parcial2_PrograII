/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Persistencia;
import Excepciones.*;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Agustín
 */

public class VehiculoRepository implements Repository<Vehiculo> {
    private final String filePath;
    private final List<Vehiculo> vehiculos;
    private static final GestorPersistencia<Vehiculo> persistencia = new GestorPersistencia<>("vehiculos.dat");
    private int ultimoId;

    public VehiculoRepository(String filePath) {
        this.filePath = filePath;
        this.vehiculos = persistencia.cargar();
        this.ultimoId = vehiculos.isEmpty() ? 0 : vehiculos.getLast().getId();
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public String getFilePath() {
        return filePath;
    }

    public int getUltimoId() {
        return ultimoId;
    }

    public void setUltimoId(int ultimoId) {
        this.ultimoId = ultimoId;
    }
    
    @Override
    public void add(Vehiculo vehiculo) {
        vehiculo.setId(ultimoId++);
        vehiculos.add(vehiculo);
        persistencia.guardar(vehiculos);
    }

    @Override
    public Optional<Vehiculo> findById(int id) {
        return Optional.ofNullable(vehiculos.stream().filter(v -> v.getId() == id).findFirst().orElseThrow(() -> new VehiculoNotFoundException("Vehiculo no encontrado con id: " + id)));
    }

    @Override
    public List<Vehiculo> findAll() {
        return new ArrayList<>(vehiculos);
    }
}