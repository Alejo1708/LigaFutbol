package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase TablaPosiciones 
 * Esta clase organiza los equipos segun sus resultados. 
 */
public class TablaPosiciones {
    private List<Equipo> equipos;  // Lista de todos los equipos
    
    /**
     * Constructor - Recibe la lista de equipos de la liga
     * @param equipos Lista de equipos a clasificar
     */
    public TablaPosiciones(List<Equipo> equipos) {
        // Creo una copia de la lista para no modificar la original
        this.equipos = new ArrayList<Equipo>(equipos);
    }
    
    /**
     * Calcula las posiciones ordenando los equipos
     * @param partidos Lista de partidos (por ahora no se usa, pero esta en el UML)
     */
    public void calcularPosiciones(List<Partido> partidos) {
        ordenarEquipos();  //Se ordenan los equipos
        
    }
    
    /**
     * Getter para obtener la lista de equipos
     */
    public List<Equipo> getEquipos() {
        return equipos;
    }
    
    /**
     * METODO CLAVE: Ordena los equipos segun los criterios del futbol
     * 
     * Criterios de desempate
     * 1. Mayor cantidad de puntos
     * 2. Mayor diferencia de goles
     * 3. Mayor cantidad de goles a favor
     */
    public void ordenarEquipos() {
        equipos.sort((equipo1, equipo2) -> {
            // Se obtienen los puntos de cada equipo
            int puntosE1 = equipo1.getPuntos();
            int puntosE2 = equipo2.getPuntos();
            
            // Criterio 1: Comparar puntos, el que mas tenga va de primero
            int puntosComp = Integer.compare(puntosE2, puntosE1);
            if (puntosComp != 0) {
                return puntosComp;  // Si hay diferencia, ya esta decidido
            }
            
            // Criterio 2: Si tienen los mismos puntos, se compara la diferencia de goles
            int difGolesE1 = equipo1.getDiferenciaGoles();
            int difGolesE2 = equipo2.getDiferenciaGoles();
            int difGolesComp = Integer.compare(difGolesE2, difGolesE1);
            if (difGolesComp != 0) {
                return difGolesComp;  // Si hay diferencia, ya esta decidido
            }
            
            // Criterio 3: Si siguen empatados, el que metio mas goles va primero
            int golesFavorE1 = equipo1.getEstadisticas().getGolesFavor();
            int golesFavorE2 = equipo2.getEstadisticas().getGolesFavor();
            return Integer.compare(golesFavorE2, golesFavorE1);
        });
    }
    
    /**
     * Muestra la tabla de posiciones en consola 
     */
    public void mostrarTabla() {
        System.out.println("______________________________________________________");
        System.out.println("|                   TABLA DE POSICIONES               |");
        System.out.println("|_____________________________________________________|");
        // Encabezados: Equipo, Partidos Jugados, Victorias, Empates, Derrotas, etc.
        System.out.printf("%-20s %3s %3s %3s %3s %3s %3s %3s %4s\n", 
                         "Equipo", "PJ", "V", "E", "D", "GF", "GC", "DG", "PTS");
        System.out.println("───────────────────────────────────────────────────────────────");
        
        // Se recorre cada equipo y se muestran sus estadisticas
        for (Equipo equipo : equipos) {
            EstadisticasEquipo est = equipo.getEstadisticas();
            String nombreEquipo = equipo.getNombre();
            int pj = est.getPartidosJugados();
            int v = est.victorias;
            int e = est.empates;
            int d = est.derrotas;
            int gf = est.getGolesFavor();
            int gc = est.getGolesContra();
            int dg = est.getDiferenciaGoles();
            int pts = equipo.getPuntos();
            
            System.out.printf("%-20s %3d %3d %3d %3d %3d %3d %+3d %4d\n",
                            nombreEquipo, pj, v, e, d, gf, gc, dg, pts);
        }
        System.out.println("____________________________________________________");
    
}
}