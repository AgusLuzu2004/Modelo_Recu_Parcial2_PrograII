/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Persistencia;
import Excepciones.*;
import Modelo.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Agustín
 */

public class ReservaRepository implements Repository<Reserva>, Serializable {
    private static final long serialVersionUID = 1L;
    private final String filePath;
    private final List<Reserva> reservas;
    private static final GestorPersistencia<Reserva> persistencia = new GestorPersistencia<>("reservas.dat");

    public ReservaRepository(String filePath) {
        this.filePath = filePath;
        this.reservas = persistencia.cargar();
    }

    public String getFilePath() {
        return filePath;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public void add(Reserva reserva) {
        reservas.add(reserva);
        persistencia.guardar(reservas);
    }

    @Override
    public Optional<Reserva> findById(int id) {
        return Optional.ofNullable(reservas.stream().filter(r -> r.getIdReserva() == id).findFirst().orElseThrow(() -> new ReservaNotFoundException("Reserva no encontrada con id: " + id)));
    }

    @Override
    public List<Reserva> findAll() {
        return new ArrayList<>(reservas);
    }
}