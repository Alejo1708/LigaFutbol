//PARTE DE Alejo1708

package main;

// Se importan todas las clases que se van a usar
import modelo.Equipo;
import modelo.Jugador;
import modelo.Arbitro;
import modelo.Estadio;
import modelo.Partido;
import modelo.Liga;
import modelo.TablaPosiciones;
import modelo.Persona;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Main 
 * Se crean todos los equipos, jugadores, arbitros, estadios y se simula la liga
 * 
 *CORRECCIONES APLICADAS
 * 1. Los arbitros ahora se agregan tambien a GestionArbitros 
 * 2. Los estadios ahora se agregan tambien a GestionEstadios 
 * 3. La TablaPosiciones se asigna a la Liga 
 * 4. Se agrego demostracion de GestionArbitros y GestionEstadios funcionando
 */
public class Main {
    public static void main(String[] args) {
        // Mensaje de bienvenida
        System.out.println("_______________________________________________________");
        System.out.println("|          LIGA DE FUTBOL PROFESIONAL COLOMBIANO      |");
        System.out.println("|                    Temporada 2025                   |");
        System.out.println("|_____________________________________________________|");
        
        // Se crea la liga completa
        // Liga ahora crea automaticamente GestionArbitros y GestionEstadios 
        Liga liga = new Liga();
        
        // INTEGRANTE 1 - Alejo1708: Creacion de Equipos y sus Jugadores
        
        // CREO LOS 4 EQUIPOS DE LA LIGA
        Equipo nacional = new Equipo("Atletico Nacional");
        Equipo onceCaldas = new Equipo("Once Caldas");
        Equipo america = new Equipo("America");
        Equipo millonarios = new Equipo("Millonarios");
        
        // ATLETICO NACIONAL - 11 JUGADORES 
        // Portero
        nacional.getPersonas().add(new Jugador("David Ospina", "Portero", 1));
        
        // Defensas (4 jugadores)
        nacional.getPersonas().add(new Jugador("William Tesillo", "Defensa", 16));
        nacional.getPersonas().add(new Jugador("Simon Garcia", "Defensa", 28));
        nacional.getPersonas().add(new Jugador("Camilo Candido", "Defensa", 13));
        nacional.getPersonas().add(new Jugador("Andres Roman", "Defensa", 6));
        
        // Centrocampistas (3 jugadores)
        nacional.getPersonas().add(new Jugador("Andres Sarmiento", "Centrocampista", 29));
        nacional.getPersonas().add(new Jugador("Edwin Cardona", "Centrocampista", 10));
        nacional.getPersonas().add(new Jugador("Matheus Uribe", "Centrocampista", 8));
        
        // Delanteros (3 jugadores)
        nacional.getPersonas().add(new Jugador("Marino Hinestroza", "Delantero", 18));
        nacional.getPersonas().add(new Jugador("Jorman Campuzano", "Delantero", 21));
        nacional.getPersonas().add(new Jugador("Alfredo Morelos", "Delantero", 9));
        
        // ONCE CALDAS - 11 JUGADORES 
        // Portero
        onceCaldas.getPersonas().add(new Jugador("James Aguirre", "Portero", 12));
        
        // Defensas (4 jugadores)
        onceCaldas.getPersonas().add(new Jugador("Juan David Cuesta", "Defensa", 22));
        onceCaldas.getPersonas().add(new Jugador("Kevin Andres Cuesta Rodriguez", "Defensa", 23));
        onceCaldas.getPersonas().add(new Jugador("Jaider Riquett", "Defensa", 18));
        onceCaldas.getPersonas().add(new Jugador("Kevin Tamayo", "Defensa", 30));
        
        // Centrocampistas (3 jugadores)
        onceCaldas.getPersonas().add(new Jugador("Mateo Garcia", "Centrocampista", 19));
        onceCaldas.getPersonas().add(new Jugador("Robert Mejia", "Centrocampista", 88));
        onceCaldas.getPersonas().add(new Jugador("Alejandro Garcia", "Centrocampista", 20));
        
        // Delanteros (3 jugadores)
        onceCaldas.getPersonas().add(new Jugador("Dayro Moreno", "Delantero", 17));
        onceCaldas.getPersonas().add(new Jugador("Mateo Zuleta", "Delantero", 28));
        onceCaldas.getPersonas().add(new Jugador("Michael Barrios", "Delantero", 7));
        
        // Agrego Atletico Nacional y Once Caldas a la liga
        liga.getEquipos().add(nacional);
        liga.getEquipos().add(onceCaldas);
        
        // FIN INTEGRANTE 1 - Alejo1708