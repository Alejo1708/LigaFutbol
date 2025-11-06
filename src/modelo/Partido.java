package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Partido 
 * 
 *Clase mas importante para simular los partidos.
 */
public class Partido {
    // Elementos que componen un partido
    private Equipo equipoLocal;      // El equipo que juega en casa
    private Equipo equipoVisitante;  // El equipo visitante
    private Arbitro arbitro;         // El arbitro que dirige el partido
    private Estadio estadio;         // Donde se juega
    private int golesLocal;          // Goles del equipo local
    private int golesVisitante;      // Goles del equipo visitante
    
    /**
     * Constructor - Para crear un partido se necesitan todos estos elementos
     * @param equipoLocal El equipo de casa
     * @param equipoVisitante El equipo de visita
     * @param arbitro Quien va a pitar el partido
     * @param estadio Donde se va a jugar
     */
    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Arbitro arbitro, Estadio estadio) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.arbitro = arbitro;
        this.estadio = estadio;
        this.golesLocal = 0;       // Empieza 0-0
        this.golesVisitante = 0;
    }
    
    /**
     * Getters - Para consultar informacion del partido
     */
    public Equipo getEquipoLocal() {
        return equipoLocal;
    }
    
    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
    
    public int getGolesLocal() {
        return golesLocal;
    }
    
    public int getGolesVisitante() {
        return golesVisitante;
    }
    
    public Arbitro getArbitro() {
        return arbitro;
    }
    
    public Estadio getEstadio() {
        return estadio;
    }
    
    /**
     * Actualiza las estadisticas de los dos equipos despues del partido
     */
    public void actualizarEstadisticas() {
        this.equipoLocal.registrarResultado(this.golesLocal, this.golesVisitante);
        this.equipoVisitante.registrarResultado(this.golesVisitante, this.golesLocal);
    }
    
    /**
     *Metodo-simula todo el partido
     * Aqui se deciden los goles, quien anota, las tarjetas, etc.
     */
    public void simularPartido() {
        //Decidir cuantos goles habra (aleatorio entre 0 y 4 por equipo)
        this.golesLocal = (int)(Math.random() * 5);
        this.golesVisitante = (int)(Math.random() * 5);
        
        // Asignar quien hizo los goles del equipo local
        asignarGoleadoresEquipo(this.equipoLocal, this.golesLocal);
        
        //Asignar quien hizo los goles del equipo visitante
        asignarGoleadoresEquipo(this.equipoVisitante, this.golesVisitante);
        
        // Paso 4: Repartir algunas tarjetas (amarillas y rojas)
        asignarTarjetas(this.equipoLocal);
        asignarTarjetas(this.equipoVisitante);
        
        // Actualizar las estadisticas de ambos equipos
        actualizarEstadisticas();
    }
    
    /**
     * Metodo privado que asigna los goleadores de un equipo
     * Los porteros no pueden anotar
     * Las probabilidades de anotar dependen de la posicion del jugador:
     * - Delanteros: Alta probabilidad (4x)
     * - Centrocampistas: Probabilidad media (2x)
     * - Defensas: Baja probabilidad (1x)
     * - Porteros: NO anotan (0x)
     * 
     * @param equipo El equipo al que se le van a asignar goleadores
     * @param cantidadGoles Cuantos goles metio este equipo
     */
    private void asignarGoleadoresEquipo(Equipo equipo, int cantidadGoles) {
        List<Jugador> jugadores = equipo.getJugadores();
        List<Jugador> jugadoresQueAnotan = new ArrayList<Jugador>();
        
        // Se crea una lista ajustada segun la posicion del jugador
        // Si un jugador aparece mas veces en la lista, tiene mas probabilidad de anotar
        for (Jugador j : jugadores) {
            String pos = j.getPosicion();
            
            if (pos.equals("Portero")) {
                // Los porteros no se agregan
                continue;
            } else if (pos.equals("Delantero")) {
                // Delanteros aparecen 4 veces = 4x mas probabilidad
                for (int i = 0; i < 4; i++) {
                    jugadoresQueAnotan.add(j);
                }
            } else if (pos.equals("Centrocampista")) {
                // Centrocampistas aparecen 2 veces = 2x mas probabilidad
                for (int i = 0; i < 2; i++) {
                    jugadoresQueAnotan.add(j);
                }
            } else if (pos.equals("Defensa")) {
                // Defensas aparecen 1 vez = menor probabilidad
                jugadoresQueAnotan.add(j);
            }
        }
        
        //Se asignan los goles aleatoriamente de la lista 
        for (int i = 0; i < cantidadGoles && !jugadoresQueAnotan.isEmpty(); i++) {
            // Se escoge un goleador al azar
            int indiceAleatorio = (int)(Math.random() * jugadoresQueAnotan.size());
            Jugador goleador = jugadoresQueAnotan.get(indiceAleatorio);
            goleador.registrarGol();  // Gol 
            
            // Ahora se asigna una asistencia (65% de probabilidad)
            if (Math.random() < 0.65) {
                // Se crea una lista de posibles asistentes (todos menos porteros y el goleador)
                List<Jugador> posiblesAsistentes = new ArrayList<Jugador>();
                for (Jugador j : jugadores) {
                    // No puede asistir el portero ni el mismo que anoto
                    if (!j.getPosicion().equals("Portero") && j != goleador) {
                        posiblesAsistentes.add(j);
                    }
                }
                
                // Si hay alguien que pueda asistir, se escoge al azar
                if (!posiblesAsistentes.isEmpty()) {
                    int indiceAsistente = (int)(Math.random() * posiblesAsistentes.size());
                    posiblesAsistentes.get(indiceAsistente).registrarAsistencia();
                }
            }
        }
    }
    
    /**
     * Metodo privado que reparte tarjetas al azar en un equipo
     * Simula las faltas y amonestaciones del partido
     * @param equipo El equipo al que se le van a asignar tarjetas
     */
    private void asignarTarjetas(Equipo equipo) {
        List<Jugador> jugadores = equipo.getJugadores();
        
        // 35% de probabilidad de que haya 1 o 2 amarillas en el equipo
        if (Math.random() < 0.35 && !jugadores.isEmpty()) {
            int cantidadAmarillas = (int)(Math.random() * 2) + 1;  // 1 o 2 amarillas
            for (int i = 0; i < cantidadAmarillas; i++) {
                int indiceAleatorio = (int)(Math.random() * jugadores.size());
                jugadores.get(indiceAleatorio).registrarAmarilla();  // Tarjeta amarilla 
            }
        }
        
        // 8% de probabilidad de que haya una roja
        if (Math.random() < 0.08 && !jugadores.isEmpty()) {
            int indiceAleatorio = (int)(Math.random() * jugadores.size());
            jugadores.get(indiceAleatorio).registrarRoja();  //Expulsado
        }
    }
    
    /**
     * Muestra el resultado del partido 
     * Formato: Equipo Local X - Y Equipo Visitante | Arbitro: Nombre | Estadio: Nombre
     */
    public void mostrarResultado() {
        System.out.printf("%-20s %d - %d %-20s | Arbitro: %-30s | Estadio: %s\n", 
                        this.equipoLocal.getNombre(),
                        this.golesLocal,
                        this.golesVisitante,
                        this.equipoVisitante.getNombre(),
                        this.arbitro.getNombre(),
                        this.estadio.getNombre());
    }
}