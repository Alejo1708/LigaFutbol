package gestion;

import modelo.Persona;
import modelo.Arbitro;
import modelo.Partido;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GestionArbitros - Administra a los arbitros de la liga
 * 
 * CORRECCIONES APLICADAS 
 * 1. Se agrego el metodo agregarArbitro() para poder añadir arbitros a la gestion
 * 2. Se agrego el método listarArbitros() para mostrar todos los arbitros
 * 3. Se agrego el getter getPersonas() para acceder a la lista desde afuera
 * 
 * Ahora esta clase se usa desde Liga para gestionar arbitros de forma organizada
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
    
    // CORRECCION 1: Método para agregar arbitros 
    /**
     * Agrega un arbitro a la gestion
     * Este metodo permite añadir arbitros al sistema de gestion
     * 
     * @param arbitro El arbitro que se va a agregar
     */
    public void agregarArbitro(Arbitro arbitro) {
        this.personas.add(arbitro);
    }
    
    /**
     * Metodo para asignar un arbitro a un partido, por ahora esta vacio porque los arbitros se asignan directamente en el constructor de Partido, pero podria tener logica automatica
     * 
     * @param partido El partido al que se le asignara un arbitro
     */
    public void asignarArbitro(Partido partido) {
        // Por ahora esta vacio porque se asignan arbitros directamente
    }
    
    /**
     * Elimina una persona (arbitro) del sistema por nombre
     * Util si un arbitro se retira o ya no esta disponible
     * 
     * @param nombre El nombre del arbitro a eliminar
     */
    public void eliminarPersona(String nombre) {
        // Elimina cualquier persona que tenga ese nombre
        personas.removeIf(p -> p.getNombre().equals(nombre));
    }
    
    /**
     * Busca un arbitro especifico por su nombre
     * Permite encontrar un arbitro en el sistema de gestion
     * 
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
    
    // CORRECCION 2: Metodo para listar arbitros 
    /**
     * Lista todos los arbitros registrados en el sistema
     * Muestra en consola la informacion de cada arbitro
     */
    public void listarArbitros() {
        System.out.println("-----LISTA DE ARBITROS-----");
        if (personas.isEmpty()) {
            System.out.println("No hay arbitros registrados");
        } else {
            for (Persona p : personas) {
                if (p instanceof Arbitro) {
                    p.mostrarInformacion();  // Usa el polimorfismo para mostrar informacion
                }
            }
        }
        System.out.println("________________________");
    }
    
    //CORRECCION 3: Getter para acceder a la lista 
    /**
     * Obtiene la lista de personas (arbitros) del sistema
     * Permite acceder a la lista desde otras clases
     * 
     * @return Lista de personas (arbitros)
     */
    public List<Persona> getPersonas() {
        return personas;
    }
}