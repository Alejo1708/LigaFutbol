package modelo;

/**
 * Clase EstadisticasEquipo - Los numeros y resultados de un equipo 
 * Esta clase guarda las estadisticas de un equipo, cuantos partidos jugo, gano, goles, etc
 */
public class EstadisticasEquipo {
    // Atributos publicos (para facilitar el acceso desde TablaPosiciones)
    public int partidosJugados;  // Total de partidos jugados
    public int victorias;        // Partidos ganados
    public int empates;          // Partidos empatados
    public int derrotas;         // Partidos perdidos
    
    // Atributos privados (se consultan con getters)
    private int golesFavor;      // Goles anotados por el equipo
    private int golesContra;     // Goles recibidos por el equipo
    
    /**
     * Constructor - Equipo nuevo, todo en cero
     */
    public EstadisticasEquipo() {
        this.partidosJugados = 0;
        this.victorias = 0;
        this.empates = 0;
        this.derrotas = 0;
        this.golesFavor = 0;
        this.golesContra = 0;
    }
    
    /**
     * Actualiza las estadisticas despues de cada partido
     * suma los partidos jugados y los goles
     * @param golesFavor Goles que metio el equipo en este partido
     * @param golesContra Goles que recibio en este partido
     */
    public void actualizarEstadisticas(int golesFavor, int golesContra) {
        this.partidosJugados++;         // Un partido mas en el historial
        this.golesFavor += golesFavor;  // Sumar los goles anotados
        this.golesContra += golesContra; // Sumar los goles recibidos
    }
    
    /**
     * Getters - Para consultar las estadisticas
     */
    public int getPartidosJugados() {
        return partidosJugados;
    }
    
    public int getGolesFavor() {
        return golesFavor;
    }
    
    public int getGolesContra() {
        return golesContra;
    }
    
    /**
     * Calcula la diferencia de goles del equipo
     * @return Diferencia de goles
     */
    public int getDiferenciaGoles() {
        return golesFavor - golesContra;
    }
}
