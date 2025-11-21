package com.mycompany.api.modelo;

public class Jugador {
    private String nombre;
    private String posicion;
    private int dorsal;

    public Jugador(String nombre, String posicion, int dorsal) {
        this.nombre = nombre;
        this.posicion = posicion;
        this.dorsal = dorsal;
    }

    // Getters obligatorios para que el JSON se genere bien
    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getDorsal() {
        return dorsal;
    }
}