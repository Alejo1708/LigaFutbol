package gestion;

import modelo.Estadio;
import modelo.Partido;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionEstadios - Administra los estadios de la liga

 * Se encarga de manejar todos los estadios donde se juegan los partidos.
 
 */
public class GestionEstadios {
    // Lista de todos los estadios disponibles
    private List<Estadio> estadios;
    
    /**
     * Constructor - Crea el sistema de gestion vacio
     */
    public GestionEstadios() {
        this.estadios = new ArrayList<>();
    }
    
    /**
     * Metodo para asignar un estadio a un partido
     
     * @param partido El partido al que se asignara un estadio
     */
    public void asignarEstadio(Partido partido) {
        // Por ahora esta vacío porque se asignan estadios directamente
       
    }
    
    /**
     * Elimina un estadio del sistema por nombre
  
     * @param nombre El nombre del estadio a eliminar
     */
    public void eliminarEstadio(String nombre) {
        // Elimina cualquier estadio que tenga ese nombre
        estadios.removeIf(e -> e.getNombre().equals(nombre));
    }
    
    /**
     * Busca un estadio especifico por su nombre
     * @param nombre El nombre del estadio a buscar
     * @return El estadio encontrado, o null si no existe
     */
    public Estadio buscarEstadio(String nombre) {
        for (Estadio e : estadios) {
            // Si se encuentra el estadio con ese nombre, se devuelve
            if (e.getNombre().equals(nombre)) {
                return e;
            }
        }
        return null;  // No se encontro
    }
}