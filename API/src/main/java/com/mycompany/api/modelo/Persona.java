package com.mycompany.api.modelo;

/**
 * Clase abstracta Persona.
 * Es la clase base para Jugador.
 */
public abstract class Persona {

    protected String nombre;

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Este metodo se deja abstracto porque Jugador lo implementa.
    public abstract void mostrarInformacion();
}