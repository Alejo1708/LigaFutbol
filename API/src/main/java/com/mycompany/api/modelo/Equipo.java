package com.mycompany.api.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Equipo (versión para API)
 * Versión simplificada y autónoma para el módulo API.
 */
public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    // Constructor público que recibe el nombre del equipo
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Getter de jugadores
    public List<Jugador> getJugadores() {
        return jugadores;
    }

    // Permite agregar jugadores si más adelante lo necesitas
    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", jugadores=" + jugadores.size() + '}';
    }
}