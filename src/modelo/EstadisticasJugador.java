package modelo;

/**
 * Clase EstadisticasJugador
 * Guarda todas las estadisticas de un jugador: goles, asistencias y tarjetas.
 * Es privada porque solo el jugador y el sistema deben modificar estas cifras.
 */
public class EstadisticasJugador {
    // Atributos privados - nadie puede modificarlos directamente desde afuera
    private int goles;        // Cantidad de goles anotados
    private int asistencias;  // Cantidad de asistencias
    private int amarillas;    // Tarjetas amarillas
    private int rojas;        // Tarjetas rojas 
    
    /**
     * Constructor - Cuando un jugador llega, todas sus estadisticas estan en cero
     */
    public EstadisticasJugador() {
        this.goles = 0;
        this.asistencias = 0;
        this.amarillas = 0;
        this.rojas = 0;
    }
    
    /**
     * Metodos para registrar estadisticas durante los partidos
     * Cada vez que pasa algo en el partido, se llaman estos metodos
     */
    
    public void registrarGol(int cantidad) {
        this.goles += cantidad;  // Se suman los goles
    }
    
    public void registrarAsistencia(int cantidad) {
        this.asistencias += cantidad;  // Se suman las asistencias
    }
    
    public void registrarAmarilla() {
        this.amarillas++;  // Una amarilla mas al historial
    }
    
    public void registrarRoja() {
        this.rojas++;  // Una roja mas 
    }
    
    /**
     * Getters - Para consultar las estadisticas sin poder modificarlas
     */
    public int getGoles() {
        return goles;
    }
    
    public int getAsistencias() {
        return asistencias;
    }
    
    public int getAmarillas() {
        return amarillas;
    }
    
    public int getRojas() {
        return rojas;
    }
}