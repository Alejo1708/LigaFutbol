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
        



// ENDPOINT 3 jhosusruiz: GET /estadios
        // Devuelve todos los estadios con nombre, ciudad, capacidad
        // --------------------------------------------------------------------------------------------------
        Spark.get("/estadios", (req, res) -> {
            res.type("application/json");

            List<Estadio> lista = new ArrayList<>();

            for (String e : DatosLiga.ESTADIOS) {
                String[] partes = e.split(", ");

                String nombre = partes[0];
                String ciudad = partes[1];
                int capacidad = Integer.parseInt(partes[2]);

                lista.add(new Estadio(nombre, ciudad, capacidad));
            }

            return ServidorUtils.toJson(lista);
        });

        System.out.println("Servidor API corriendo en http://localhost:4567/");
    }
}