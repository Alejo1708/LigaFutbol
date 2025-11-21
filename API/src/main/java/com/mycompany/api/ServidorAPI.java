package com.mycompany.api;

import com.mycompany.api.datos.DatosLiga;
import com.mycompany.api.modelo.Jugador;
import com.mycompany.api.modelo.Equipo;
import com.mycompany.api.modelo.Estadio;
import spark.Spark;

import java.util.ArrayList;
import java.util.List;

public class ServidorAPI {

    public static void main(String[] args) {

        // -----------------------------------------
        // INICIAR SERVIDOR EN PUERTO 4567
        // -----------------------------------------
        Spark.port(4567);

        // ---------------------------------------------------
        // ENDPOINT 1 Alejo1708: GET /jugadores
        // Devuelve todos los jugadores de todos los equipos
        // ---------------------------------------------------
        Spark.get("/jugadores", (req, res) -> {
            res.type("application/json");

            List<Jugador> lista = new ArrayList<>();

            // Recorrer cada equipo y sus jugadores en DatosLiga
            DatosLiga.JUGADORES.forEach((equipo, jugadores) -> {

                for (String j : jugadores) {

                    // Cada linea tiene formato "Nombre, posicion, dorsal"
                    String[] partes = j.split(", ");

                    String nombre = partes[0];
                    String posicion = partes[1];
                    int dorsal = Integer.parseInt(partes[2]);

                    // Crear el jugador y agregarlo a la lista global
                    lista.add(new Jugador(nombre, posicion, dorsal));
                }
            });

            return ServidorUtils.toJson(lista);
        });
        
// ---------------------------------------------------------
        // ENDPOINT 2 jcvmurillo12: GET /equipos
        // Devuelve los equipos CON SUS JUGADORES correspondientes
        // ---------------------------------------------------------
        Spark.get("/equipos", (req, res) -> {
            res.type("application/json");

            // Lista que se enviara como respuesta
            List<Equipo> lista = new ArrayList<>();

            // Recorrer la lista de nombres de equipos
            for (String nombreEquipo : DatosLiga.EQUIPOS) {

                // Lista donde se guardaran los jugadores de este equipo
                List<Jugador> jugadoresDelEquipo = new ArrayList<>();

                // Obtener los jugadores del mapa JUGADORES
                List<String> listaTextoJugadores = DatosLiga.JUGADORES.get(nombreEquipo);

                // Si el equipo si tiene jugadores definidos en DatosLiga
                if (listaTextoJugadores != null) {

                    // Convertir cada linea en un objeto Jugador
                    for (String linea : listaTextoJugadores) {
                    // Cada string tiene formato: "nombre, posicion, dorsal"
                        String[] partes = linea.split(", ");

                        String nombreJugador = partes[0];
                        String posicion = partes[1];
                        int dorsal = Integer.parseInt(partes[2]);

                        // Crear objeto Jugador y agregarlo a la lista del equipo
                        jugadoresDelEquipo.add(
                            new Jugador(nombreJugador, posicion, dorsal)
                        );
                    }
                }

                // Crear el equipo con su lista de jugadores
                Equipo equipo = new Equipo(nombreEquipo, jugadoresDelEquipo);

                // Agregar a la lista final
                lista.add(equipo);
            }

            // Convertir la lista completa a JSON
            return ServidorUtils.toJson(lista);
        });