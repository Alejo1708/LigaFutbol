package gestion;

import modelo.Estadio;
import modelo.Partido;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionEstadios - Administra los estadios de la liga
 * Se encarga de manejar todos los estadios donde se juegan los partidos.
 * 
 * CORRECCIONES APLICADAS 
 * 1. Se agrego el metodo agregarEstadio() para poder añadir estadios a la gestion
 * 2. Se agrego el metodo listarEstadios() para mostrar todos los estadios
 * 3. Se agrego el getter getEstadios() para acceder a la lista desde afuera
 * 
 * Ahora esta clase se usa desde Liga para gestionar estadios de forma organizada
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
    
    // CORRECCION 1: Metodo para agregar estadios 
    /**
     * Agrega un estadio a la gestion
     * Este metodo permite añadir estadios al sistema de gestion
     * 
     * @param estadio El estadio que se va a agregar
     */
    public void agregarEstadio(Estadio estadio) {
        this.estadios.add(estadio);
    }
    
    /**
     * Metodo para asignar un estadio a un partido
     * Por ahora esta vacio porque los estadios se asignan directamente en el constructor de Partido, pero podria tener logica automatica
     * 
     * @param partido El partido al que se asignara un estadio
     */
    public void asignarEstadio(Partido partido) {
        // Por ahora esta vacio porque se asignan estadios directamente
        // En el futuro podria implementarse logica como:
        // - Asignar el estadio del equipo local
        // - Verificar disponibilidad del estadio
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
     * Permite encontrar un estadio en el sistema de gestion
     * 
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
    
    // CORRECCION 2: Metodo para listar estadios
    /**
     * Lista todos los estadios registrados en el sistema
     * Muestra en consola la informacion de cada estadio
     */
    public void listarEstadios() {
        System.out.println("--------LISTA DE ESTADIOS--------");
        if (estadios.isEmpty()) {
            System.out.println("No hay estadios registrados");
        } else {
            for (Estadio e : estadios) {
                e.mostrarInformacion();  // Muestra la informacion del estadio
            }
        }
        System.out.println("______________________________________");
    }
    
    // CORRECCION 3: Getter para acceder a la lista 
    /**
     * Obtiene la lista de estadios del sistema
     * Permite acceder a la lista desde otras clases
     * 
     * @return Lista de estadios
     */
    public List<Estadio> getEstadios() {
        return estadios;
    }
}