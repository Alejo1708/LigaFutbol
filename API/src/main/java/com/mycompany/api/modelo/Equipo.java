package com.mycompany.api.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Equipo (version para API)
 */
public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    // -----------------------------
    // Constructor 1: solo nombre
    // Inicia la lista vacia
    // -----------------------------
    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    // -----------------------------
    // Constructor 2: nombre + lista jugadores
    // Este permite asignar jugadores desde el endpoint
    // -----------------------------
    public Equipo(String nombre, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.jugadores = jugadores;
    }

    // Getter del nombre
    public String getNombre() {
        return nombre;
    }

    // Getter de jugadores
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    // Permite agregar jugadores mas adelante si se necesita
    public void agregarJugador(Jugador j) {
        jugadores.add(j);
    }

    @Override
    public String toString() {
        return "Equipo{" + "nombre=" + nombre + ", jugadores=" + jugadores.size() + '}';
    }
}
