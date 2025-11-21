package com.mycompany.api.datos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class DatosLiga {

    // -----------------------
    // EQUIPOS
    // -----------------------
    public static final List<String> EQUIPOS = Arrays.asList(
        "Atletico Nacional",
        "Once Caldas",
        "America",
        "Millonarios"
    );

    // -----------------------
    // JUGADORES POR EQUIPO
    // -----------------------
    public static final Map<String, List<String>> JUGADORES = Map.of(
        "Atletico Nacional", Arrays.asList(
            "David Ospina, portero, 1",
            "William tesillo, defensa, 16",
            "Simon Garcia, defensa, 28",
            "Camilo Candido, defensa, 13",
            "Andres Roman, defensa, 6",
            "Andres Sarmiento, centrocampista, 29",
            "Edwin Cardona, centrocampista, 10",
            "Matheus Uribe, centrocampista, 8",
            "Marino Hinestroza, delantero, 18",
            "Jorman Campuzano, delantero, 21",
            "Alfredo Morelos, delantero, 9"
        ),

        "Once Caldas", Arrays.asList(
            "James Aguirre, portero, 12",
            "Juan David Cuesta, defensa, 22",
            "Kevin Andres Cuesta Rodriguez, defensa, 23",
            "Jaider Riquett, defensa, 18",
            "Kevin Tamayo, defensa, 30",
            "Mateo Garcia, centrocampista, 19",
            "Robert Mejia, centrocampista, 88",
            "Alejandro Garcia, centrocampista, 20",
            "Dayro Moreno, delantero, 17",
            "Mateo Zuleta, delantero, 28",
            "Michael barrios, delantero, 7"
        ),

        "America", Arrays.asList(
            "Jorge Soto, portero, 12",
            "Mateo Castillo Marquez, defensa, 13",
            "Cristian Tovar, defensa, 6",
            "Jean Carlos Pestaña, defensa, 24",
            "Omar Bertel, defensa, 31",
            "Cristian Barrios, centrocampista, 7",
            "Sebastian Navarro, centrocampista, 21",
            "Rafael Carrascal, centrocampista, 10",
            "Andres Roa, delantero, 15",
            "Luis Ramos, delantero, 9",
            "Jan Lucumi, delantero, 17"
        ),

        "Millonarios", Arrays.asList(
            "Diego Novoa, portero, 12",
            "Samuel Martin, defensa, 3",
            "Alex Moreno, defensa, 29",
            "Jorge Arias, defensa, 17",
            "Danovis Banguero, defensa, 20",
            "Stiven Vega, centrocampista, 28",
            "Nicolas Arrevalo, centrocampista, 5",
            "David Macalister Silva, centrocampista, 14",
            "Beckham Castro, delantero, 11",
            "Leonardo Castro, delantero, 23",
            "Edwin Mosquera, delantero, 70"
        )
    );

    // -----------------------
    // ESTADIOS
    // -----------------------
    public static final List<String> ESTADIOS = Arrays.asList(
        "Atanasio Girardot, Medellin, 45943",
        "Palogrande, Manizales, 31611",
        "Pascual Guerrero, Cali, 37899",
        "El Campin, Bogota, 39000"
    );
}