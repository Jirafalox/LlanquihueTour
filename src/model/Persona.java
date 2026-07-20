package model;

/**
 * Clase base que representa a una persona relacionada con la operacion
 * de la agencia (cliente, guia turistico, etc). Agrupa los datos
 * comunes que comparten todas las personas del sistema.
 *
 * Se relaciona con la clase Rut mediante composicion: cada Persona
 * "contiene" un objeto Rut, en lugar de guardar el RUT como un simple
 * String sin validar.
 */
public class Persona {

    private String nombre;
    private Rut rut;
    private String correo;

    public Persona(String nombre, Rut rut, String correo) {
        this.nombre = nombre;
        this.rut = rut;
        this.correo = correo;
    }

    // Getters y setters (encapsulamiento de los atributos)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Rut getRut() {
        return rut;
    }

    public void setRut(Rut rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return nombre + " | RUT: " + rut + " | Correo: " + correo;
    }
}
