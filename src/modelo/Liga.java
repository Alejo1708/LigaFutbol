package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Liga 
 * Administra los equipos, arbitros, estadios y coordina los partidos.
 */
public class Liga {
    // Listas que contienen todos los elementos de la liga
    private List<Equipo> equipos;      // Todos los equipos participantes
    private List<Arbitro> arbitros;    // Todos los arbitros disponibles
    private List<Estadio> estadios;    // Todos los estadios disponibles
    private TablaPosiciones tablaPosiciones;  // La tabla de clasificacióon
    
    /**
     * Constructor - Crea una liga vacia lista para ser llenada
     */
    public Liga() {
        this.equipos = new ArrayList<Equipo>();
        this.arbitros = new ArrayList<Arbitro>();
        this.estadios = new ArrayList<Estadio>();
    }
    
    /**
     * Metodo para generar el calendario de partidos, en este caso se hace manual
     */
    public void generarCalendario() {
        // Metodo vacio por ahora, podria generar partidos automaticamente
    }
    
    /**
     * Getters - Para acceder a las listas de la liga
     */
    public List<Equipo> getEquipos() {
        return equipos;
    }
    
    public List<Arbitro> getArbitros() {
        return arbitros;
    }
    
    public List<Estadio> getEstadios() {
        return estadios;
    }
    
    /**
     * Simula todos los partidos de una fecha
     * @param partidos Lista de partidos a simular
     */
    public void simularFecha(List<Partido> partidos) {
        // encabezado
        System.out.println("__________________________________________________________________________");
        System.out.println("|                                RESULTADOS DE LA FECHA                  |");
        System.out.println("|________________________________________________________________________|");
        
        // Se simula cada partido y se muestra el resultado
        for (Partido p : partidos) {
            p.simularPartido();      //simula el partido
            p.mostrarResultado();    // se muestra el resultado en consola
        }
        System.out.println("______________________________________________________________________________________");
    }
    
    /**
     * METODO IMPORTANTE: Muestra las estadisticas de todos los jugadores
     */
    public void mostrarEstadisticasJugadores() {
        System.out.println("________________________________________________________________________");
        System.out.println("|                         ESTADISTICAS DE JUGADORES                    |");
        System.out.println("|______________________________________________________________________|");
        System.out.printf("%-30s %-20s %-15s %6s %6s %6s %6s\n", 
                         "Jugador", "Equipo", "Posicion", "Goles", "Asist", "Amar", "Rojas");
        System.out.println("─────────────────────────────────────────────────────────────────────────────────────");
        
        // Recopila todos los jugadores de todos los equipos
        List<DatosJugador> datosJugadores = new ArrayList<DatosJugador>();
        
        for (Equipo equipo : equipos) {
            List<Jugador> jugadoresEquipo = equipo.getJugadores();
            for (Jugador jugador : jugadoresEquipo) {
                // se guarda el jugador junto con su equipo
                datosJugadores.add(new DatosJugador(jugador, equipo));
            }
        }
        
        // se ordena por cantidad de goles (el goleador primero)
        datosJugadores.sort((a, b) -> {
            int golesA = a.jugador.getEstadisticas().getGoles();
            int golesB = b.jugador.getEstadisticas().getGoles();
            // Comparar en orden descendente, mas goles primero
            return Integer.compare(golesB, golesA);
        });
        
        // Muestra todos los jugadores
        for (DatosJugador dato : datosJugadores) {
            Jugador j = dato.jugador;
            Equipo e = dato.equipo;
            EstadisticasJugador est = j.getEstadisticas();
            
            // muestra cada jugador con todas sus estadisticas
            System.out.printf("%-30s %-20s %-15s %6d %6d %6d %6d\n",
                            j.getNombre(),
                            e.getNombre(),
                            j.getPosicion(),
                            est.getGoles(),
                            est.getAsistencias(),
                            est.getAmarillas(),
                            est.getRojas());
        }
        System.out.println("________________________________________________________");
    }
    
    /**
     * Clase auxiliar interna para almacenar jugador con su equipo,  esto evita usar Object[] y hace el codigo mas limpio
     */
    private static class DatosJugador {
        Jugador jugador;
        Equipo equipo;
        
        DatosJugador(Jugador jugador, Equipo equipo) {
            this.jugador = jugador;
            this.equipo = equipo;
        }
    }
}