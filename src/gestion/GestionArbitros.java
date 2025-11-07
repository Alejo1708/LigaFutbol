
package gestion;

import modelo.Persona;
import modelo.Arbitro;
import modelo.Partido;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionArbitros - Administra a los arbitros de la liga
 */
public class GestionArbitros {
    // Lista de personas (que pueden ser arbitros)
    private List<Persona> personas;
    
    /**
     * Constructor - Crea el sistema de gestion vacio
     */
    public GestionArbitros() {
        this.personas = new ArrayList<>();
    }
    
    /**
     * Metodo para asignar un arbitro a un partido

     * @param partido El partido al que se asignara un arbitro
     */
    public void asignarArbitro(Partido partido) {
        // Por ahora esta vacio porque se asignan arbitros directamente
    }
    
    /**
     * Elimina una persona (arbitro) del sistema por nombre
     * @param nombre El nombre del arbitro a eliminar
     */
    public void eliminarPersona(String nombre) {
        // Elimina cualquier persona que tenga ese nombre
        personas.removeIf(p -> p.getNombre().equals(nombre));
    }
    
    /**
     * Busca un arbitro especifico por su nombre
     * @param nombre El nombre del arbitro a buscar
     * @return El arbitro encontrado, o null si no existe
     */
    public Arbitro buscarArbitro(String nombre) {
        for (Persona p : personas) {
            // Verifica que sea un arbitro y que tenga el nombre buscado
            if (p instanceof Arbitro && p.getNombre().equals(nombre)) {
                return (Arbitro)p;  // Se encontro
            }
        }
        return null;  // No se encontro 
    }
}