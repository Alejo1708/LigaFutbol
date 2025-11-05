package modelo;

/**
 * Clase Arbitro 
 * hereda de Persona (es una persona), pero con un rol especial.
 * No tiene estadisticas ni dorsal, solo necesita su nombre para dirigir partidos.

 */
public class Arbitro extends Persona {
    
    /**
     * Constructor - Un arbitro solo necesita su nombre
     * @param nombre El nombre del arbitro
     */
    public Arbitro(String nombre) {
        super(nombre);  // se pasa el nombre a Persona
    }
    
    /**
     * hay poliformismo
     * Un arbitro muestra su informacion de manera mas sencilla que un jugador
  
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Arbitro: " + nombre);
    }
}