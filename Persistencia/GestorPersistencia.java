/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Persistencia;
import Excepciones.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Agustín
 * @param <T>
 */

public class GestorPersistencia<T> {
    private String archivo;

    public GestorPersistencia(String archivo) {
        this.archivo = archivo;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
    public void guardar(List<T> lista) {
        
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        }
        catch (IOException e) {
            throw new PersistenceException("Error al guardar los datos: " + e.getMessage());
        }
    }
    
    public List<T> cargar() {
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (List<T>) ois.readObject();
        }
        catch (FileNotFoundException e) {
            return new ArrayList<>();
        }
        catch (IOException | ClassNotFoundException e) {
            throw new PersistenceException("Error al cargar los datos: " + e.getMessage());
        }
    }
}