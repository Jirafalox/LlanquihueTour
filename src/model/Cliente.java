package model;

/**
 * Representa a un cliente de la agencia. Hereda los datos generales
 * de Persona y agrega un atributo propio para llevar la cuenta de
 * las reservas que ha realizado.
 */
public class Cliente extends Persona {

    private int numeroReservasRealizadas;

    public Cliente(String nombre, Rut rut, String correo, int numeroReservasRealizadas) {
        super(nombre, rut, correo);
        this.numeroReservasRealizadas = numeroReservasRealizadas;
    }

    public int getNumeroReservasRealizadas() {
        return numeroReservasRealizadas;
    }

    public void setNumeroReservasRealizadas(int numeroReservasRealizadas) {
        this.numeroReservasRealizadas = numeroReservasRealizadas;
    }

    @Override
    public String toString() {
        return "Cliente -> " + super.toString() + " | Reservas realizadas: " + numeroReservasRealizadas;
    }
}
