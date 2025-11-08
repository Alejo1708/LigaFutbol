//PARTE DE Alejo1708

package main;

//  se importan todas las clases que se van a usar
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
 */
public class Main {
    public static void main(String[] args) {
        // Mensaje de bienvenida
        System.out.println("_______________________________________________________");
        System.out.println("|          LIGA DE FUTBOL PROFESIONAL COLOMBIANO      |");
        System.out.println("|                    Temporada 2025                   |");
        System.out.println("|_____________________________________________________|");
        
        // se crea la liga completa
        Liga liga = new Liga();
        
        // Creacion de Equipos y sus Jugadores
        
        //CREAR LOS 4 EQUIPOS DE LA LIGA
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
        
        // ------------TERMINO ACA-------------
       // PARTE DE jcvmurillo12: Creacion de mas Equipos, Arbitros y Estadios
        
        //AMERICA DE CALI - 11 JUGADORES 
        // Portero
        america.getPersonas().add(new Jugador("Jorge Soto", "Portero", 12));
        
        // Defensas (4 jugadores)
        america.getPersonas().add(new Jugador("Mateo Castillo Marquez", "Defensa", 13));
        america.getPersonas().add(new Jugador("Cristian Tovar", "Defensa", 6));
        america.getPersonas().add(new Jugador("Jean Carlos Pestaña", "Defensa", 24));
        america.getPersonas().add(new Jugador("Omar Bertel", "Defensa", 31));
        
        // Centrocampistas (3 jugadores)
        america.getPersonas().add(new Jugador("Cristian Barrios", "Centrocampista", 7));
        america.getPersonas().add(new Jugador("Sebastian Navarro", "Centrocampista", 21));
        america.getPersonas().add(new Jugador("Rafael Carrascal", "Centrocampista", 10));
        
        // Delanteros (3 jugadores)
        america.getPersonas().add(new Jugador("Andres Roa", "Delantero", 15));
        america.getPersonas().add(new Jugador("Luis Ramos", "Delantero", 9));
        america.getPersonas().add(new Jugador("Jan Lucumi", "Delantero", 17));
        
        // MILLONARIOS - 11 JUGADORES 
        // Portero
        millonarios.getPersonas().add(new Jugador("Diego Novoa", "Portero", 12));
        
        // Defensas (4 jugadores)
        millonarios.getPersonas().add(new Jugador("Samuel Martin", "Defensa", 3));
        millonarios.getPersonas().add(new Jugador("Alex Moreno", "Defensa", 29));
        millonarios.getPersonas().add(new Jugador("Jorge Arias", "Defensa", 17));
        millonarios.getPersonas().add(new Jugador("Danovis Banguero", "Defensa", 20));
        
        // Centrocampistas (3 jugadores)
        millonarios.getPersonas().add(new Jugador("Stiven Vega", "Centrocampista", 28));
        millonarios.getPersonas().add(new Jugador("Nicolas Arrevalo", "Centrocampista", 5));
        millonarios.getPersonas().add(new Jugador("David Macalister Silva", "Centrocampista", 14));
        
        // Delanteros (3 jugadores)
        millonarios.getPersonas().add(new Jugador("Beckham Castro", "Delantero", 11));
        millonarios.getPersonas().add(new Jugador("Leonardo Castro", "Delantero", 23));
        millonarios.getPersonas().add(new Jugador("Edwin Mosquera", "Delantero", 70));
        
      
        // Agrego America y Millonarios a la liga
        liga.getEquipos().add(america);
        liga.getEquipos().add(millonarios);
        
        // CREO LOS 4 ARBITROS 
        Arbitro arb1 = new Arbitro("Edwin Ferney Trujillo Castro");
        Arbitro arb2 = new Arbitro("Wilmar Roldan");
        Arbitro arb3 = new Arbitro("Diego Ulloa Angulo");
        Arbitro arb4 = new Arbitro("Hector Rivera");
        
        // Agrego los arbitros a la liga
        liga.getArbitros().add(arb1);
        liga.getArbitros().add(arb2);
        liga.getArbitros().add(arb3);
        liga.getArbitros().add(arb4);
        
        // CREO LOS 4 ESTADIOS 
        Estadio est1 = new Estadio("Atanasio Girardot", "Medellin", 45943);
        Estadio est2 = new Estadio("Palogrande", "Manizales", 31611);
        Estadio est3 = new Estadio("Pascual Guerrero", "Cali", 37899);
        Estadio est4 = new Estadio("El Campin", "Bogota", 39000);
        
        // Agrego los estadios a la liga
        liga.getEstadios().add(est1);
        liga.getEstadios().add(est2);
        liga.getEstadios().add(est3);
        liga.getEstadios().add(est4);
        
        // TERMINO ACA

 // PARTE DE jhosusruiz: Demostracion de Polimorfismo, Partidos y Simulacion
        
        // DEMOSTRACION DE POLIMORFISMO 
        System.out.println("________________________________________________________________");
        System.out.println("|           DEMOSTRACION DE POLIMORFISMO                       |");
        System.out.println("|         (Metodo mostrarInformacion()                         |");
        System.out.println("|______________________________________________________________|");
        
        // Lista polimorfica: Persona puede contener Jugadores y Arbitros
        List<Persona> personas = new ArrayList<Persona>();
        
        // Agrego un jugador de Nacional
        List<Jugador> jugadoresNacional = nacional.getJugadores();
        personas.add(jugadoresNacional.get(0));
        
        // Agrego un arbitro
        personas.add(arb1);
        
        // Agrego un jugador de Millonarios
        List<Jugador> jugadoresMillonarios = millonarios.getJugadores();
        personas.add(jugadoresMillonarios.get(5));
        
        System.out.println("Llamando al metodo mostrarInformacion() en objetos de diferentes tipos");
        
        // el mismo metodo se comporta diferente segun el objeto
        for (Persona p : personas) {
            p.mostrarInformacion();  
        }
        
        // CREO LOS PARTIDOS (Todos contra todos - 6 partidos) 
        List<Partido> todosLosPartidos = new ArrayList<Partido>();
        
        // cada equipo juega una vez contra los demas
        Partido p1 = new Partido(nacional, onceCaldas, arb1, est1);
        Partido p2 = new Partido(america, millonarios, arb2, est3);
        Partido p3 = new Partido(nacional, america, arb3, est1);
        Partido p4 = new Partido(onceCaldas, millonarios, arb4, est2);
        Partido p5 = new Partido(nacional, millonarios, arb1, est1);
        Partido p6 = new Partido(onceCaldas, america, arb2, est2);
        
        todosLosPartidos.add(p1);
        todosLosPartidos.add(p2);
        todosLosPartidos.add(p3);
        todosLosPartidos.add(p4);
        todosLosPartidos.add(p5);
        todosLosPartidos.add(p6);
        
        // SIMULAR TODOS LOS PARTIDOS 
        liga.simularFecha(todosLosPartidos);
        
        // CREAR Y MOSTRAR TABLA DE POSICIONES 
        TablaPosiciones tabla = new TablaPosiciones(liga.getEquipos());
        tabla.ordenarEquipos();  // se ordena por puntos, diferencia de goles, etc.
        tabla.mostrarTabla();    // Muestra la tabla en consola
        
        //  MOSTRAR ESTADISTICAS DE TODOS LOS JUGADORES 
        liga.mostrarEstadisticasJugadores();
        
        // TERMINO ACA 

    }
}