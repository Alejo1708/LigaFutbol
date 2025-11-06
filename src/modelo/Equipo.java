package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Equipo 
 * 
 * Un equipo tiene un nombre, una lista de personas (jugadores), estadisticas(victorias, empates, derrotas, etc.)
 */
public class Equipo {
    // Atributos del equipo
    private String nombre;                    // Nombre del equipo 
    private List<Persona> personas;           // Lista de personas del equipo (jugadores)
    private EstadisticasEquipo estadisticas;  // Resultados y numeros del equipo
    
    /**
     * Constructor - cuando se crea un equipo nuevo
     * @param nombre nombre del equipo
     */
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.personas = new ArrayList<>();           // Empieza sin nadie (lista vacia)
        this.estadisticas = new EstadisticasEquipo(); // Estadisticas en cero
    }
    
    /**
     * Getters - Para acceder a la informacion del equipo
     */
    public String getNombre() {
        return nombre;
    }
    
    public List<Persona> getPersonas() {
        return personas;  // devuelve la lista de personas (para agregar jugadores)
    }
    
    public EstadisticasEquipo getEstadisticas() {
        return estadisticas;
    }
    
    /**
     * Metodo para registrar el resultado de un partido
     * Actualiza las estadisticas segun el resultado
     * @param golesFavor Goles que metio este equipo
     * @param golesContra Goles que recibio
     */
    public void registrarResultado(int golesFavor, int golesContra) {
        // Primero se actualizan los numeros generales
        estadisticas.actualizarEstadisticas(golesFavor, golesContra);
        
        // Luego se determina si gano, empato o perdio
        if (golesFavor > golesContra) {
            estadisticas.victorias++;   // Gano
        } else if (golesFavor < golesContra) {
            estadisticas.derrotas++;    // Perdio
        } else {
            estadisticas.empates++;     // Empate 
        }
    }
    
    /**
     * Metodo para obtener solo los jugadores del equipo
     * se filtra la lista de personas para que queden solo los jugadores
     * (por si en el futuro agregamos tecnicos )
     * @return Lista solo con jugadores
     */
    public List<Jugador> getJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        for (Persona p : personas) {
            // Si la persona es un jugador, se agrega a la lista
            if (p instanceof Jugador) {
                jugadores.add((Jugador) p);
            }
        }
        return jugadores;
    }
    
    /**
     * Calcula los puntos del equipo en la tabla
     * victorias valen 3 puntos, empates 1 punto, derrotas 0
     * @return Total de puntos acumulados
     */
    public int getPuntos() {
        return estadisticas.victorias * 3 + estadisticas.empates;
    }
    
    /**
     * Calcula la diferencia de goles (goles a favor - goles en contra)
     * Importante para el desempate en la tabla de posiciones
     * @return La diferencia de goles (puede ser negativa)
     */
    public int getDiferenciaGoles() {
        return estadisticas.getGolesFavor() - estadisticas.getGolesContra();
    }
}