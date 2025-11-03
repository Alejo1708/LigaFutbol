package modelo;

/**
 * Clase abstracta Persona 
 * 
 * Esta es como la "madre" de todas las personas en este proyecto
 * No se pueden crear personas directamente (es abstracta), pero si se pueden crear jugadores y arbitros que hereden de ella

 */
public abstract class Persona {
    // El nombre es "protected" para que los hijos (Jugador, Arbitro) puedan usarlo
    protected String nombre;
    
    /**
     * Constructor - Cuando se crea cualquier persona es necesario su nombre
     * @param nombre El nombre de la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Metodo para obtener el nombre
     * @return El nombre de la persona
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * METODO ABSTRACTO 
     * 
     * Cada tipo de persona (Jugador o Arbitro) mostrara su informacion de manera diferente. 
     */
    public abstract void mostrarInformacion();
}