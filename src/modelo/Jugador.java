package modelo;

/**
 * Clase Jugador - Representa a un futbolista
 * 
 * Hereda de Persona, lo que significa que es una persona, pero con caracteristicas especiales: tiene posicion, dorsal y estadisticas.
 */
public class Jugador extends Persona {
    // Atributos privados - solo el jugador maneja sus propios datos
    private String posicion;  // Portero, Defensa, Centrocampista o Delantero
    private int dorsal;       // El numero de su camiseta
    private EstadisticasJugador estadisticas;  // Sus goles, asistencias, tarjetas, etc.
    
    /**
     * Constructor - Cuando se ficha un jugador, se necesitan estos datos
     * @param nombre El nombre completo del jugador
     * @param posicion Su posicion en el campo
     * @param dorsal El numero de su camiseta
     */
    public Jugador(String nombre, String posicion, int dorsal) {
        super(nombre);  //Se le pasa el nombre a la clase Persona 
        this.posicion = posicion;
        this.dorsal = dorsal;
        // Se crean sus estadisticas en cero
        this.estadisticas = new EstadisticasJugador();
    }
    
    // Getters - metodos para consultar informacion del jugador
    public String getPosicion() {
        return posicion;
    }
    
    public int getDorsal() {
        return dorsal;
    }
    
    public EstadisticasJugador getEstadisticas() {
        return estadisticas;
    }
    
    /**
     * POLIMORFISMO 
     * Se implementa el metodo abstracto de Persona 
     * Un jugador muestra su nombre, posicion y dorsal
     */
    @Override
    public void mostrarInformacion() {
        System.out.println("Jugador: " + nombre + " - Posicion: " + posicion + " - Dorsal: " + dorsal);
    }
    
    /**
     * Metodos para registrar acciones del jugador durante los partidos
     * Estos metodos se llaman cuando el jugador hace algo en un partido
     */
    public void registrarGol() {
        estadisticas.registrarGol(1);  // Gol
    }
    
    public void registrarAsistencia() {
        estadisticas.registrarAsistencia(1);  // Asistencia
    }
    
    public void registrarAmarilla() {
        estadisticas.registrarAmarilla();  // Amarilla
    }
    
    public void registrarRoja() {
        estadisticas.registrarRoja();  // Roja
    }
}