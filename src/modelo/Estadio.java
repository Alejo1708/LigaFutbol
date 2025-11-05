package modelo;

/**
 * Clase Estadio
 * Representa los estadios donde se disputan los partidos.
 * Cada estadio tiene un nombre, esta en una ciudad y tiene una capacidad.
 */
public class Estadio {
    // Atributos privados del estadio
    private String nombre;     // El nombre del estadio
    private String ciudad;     // La ciudad donde esta ubicado
    private int capacidad;     // Cuantos hinchas pueden entrar
    
    /**
     * Constructor - Para crear un estadio se necesita toda su informacion
     * @param nombre Nombre del estadio 
     * @param ciudad Ciudad donde esta
     * @param capacidad Cantidad de personas que caben 
     */
    public Estadio(String nombre, String ciudad, int capacidad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
    }
    
    /**
     * Getters - Para consultar informacion del estadio
     */
    public String getNombre() {
        return nombre;
    }
    
    public String getCiudad() {
        return ciudad;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    /**
     * Metodo para mostrar la informacion completa del estadio
     * Util cuando cuando se quiere saber donde se jugara un partido
     */
    public void mostrarInformacion() {
        System.out.println("Estadio: " + nombre + " | Ciudad: " + ciudad + " | Capacidad: " + capacidad);
    }
}